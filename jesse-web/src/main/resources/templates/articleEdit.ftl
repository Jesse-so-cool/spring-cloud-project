<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Jesse">

    <title>文章编辑</title>
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/jquery.scrollto.js"></script>
    <script src="/js/pagedown.js"></script>
    <script src="/js/pagedown-extra.js"></script>
    <script src="/js/diff.js"></script>
    <script>
        $(document).ready(function () {
            var textarea = $('#text'),
                    toolbar = $('<div class="markdown-editor" id="md-button-bar" />').insertBefore(textarea.parent())
            preview = $('<div id="md-preview" class="md-hidetab" />').insertAfter('.markdown-editor');

            var options = {};

            options.strings = {
                bold: '加粗 <strong> Ctrl+B',
                boldexample: '加粗文字',

                italic: '斜体 <em> Ctrl+I',
                italicexample: '斜体文字',

                link: '链接 <a> Ctrl+L',
                linkdescription: '请输入链接描述',

                quote: '引用 <blockquote> Ctrl+Q',
                quoteexample: '引用文字',

                code: '代码 <pre><code> Ctrl+K',
                codeexample: '请输入代码',

                image: '图片 <img> Ctrl+G',
                imagedescription: '请输入图片描述',

                olist: '数字列表 <ol> Ctrl+O',
                ulist: '普通列表 <ul> Ctrl+U',
                litem: '列表项目',

                heading: '标题 <h1>/<h2> Ctrl+H',
                headingexample: '标题文字',

                hr: '分割线 <hr> Ctrl+R',
                more: '摘要分割线 <!--more--> Ctrl+M',

                undo: '撤销 - Ctrl+Z',
                redo: '重做 - Ctrl+Y',
                redomac: '重做 - Ctrl+Shift+Z',

                fullscreen: '全屏 - Ctrl+J',
                exitFullscreen: '退出全屏 - Ctrl+E',
                fullscreenUnsupport: '此浏览器不支持全屏操作',

                imagedialog: '<p><b>插入图片</b></p><p>请在下方的输入框内输入要插入的远程图片地址</p>',
                linkdialog: '<p><b>插入链接</b></p><p>请在下方的输入框内输入要插入的链接地址</p>',

                ok: '确定',
                cancel: '取消'
            };

            var converter = new Markdown.Converter(),
                    editor = new Markdown.Editor(converter, '', options),
                    diffMatch = new diff_match_patch(), last = '', preview = $('#md-preview'),
                    mark = '@mark' + Math.ceil(Math.random() * 100000000) + '@',
                    span = '<span class="diff" />';

            // 设置markdown
            Markdown.Extra.init(converter, {
                extensions: ["tables", "fenced_code_gfm", "def_list", "attr_list", "footnotes"]
            });

            // 自动跟随
            converter.hooks.chain('postConversion', function (html) {
                // clear special html tags
                html = html.replace(/<\/?(\!doctype|html|head|body|link|title|input|select|button|textarea|style|noscript)[^>]*>/ig, function (all) {
                    return all.replace(/&/g, '&amp;')
                            .replace(/</g, '&lt;')
                            .replace(/>/g, '&gt;')
                            .replace(/'/g, '&#039;')
                            .replace(/"/g, '&quot;');
                });

                // clear hard breaks
                html = html.replace(/\s*((?:<br>\n)+)\s*(<\/?(?:p|div|h[1-6]|blockquote|pre|table|dl|ol|ul|address|form|fieldset|iframe|hr|legend|article|section|nav|aside|hgroup|header|footer|figcaption|li|dd|dt)[^\w])/gm, '$2');

                if (html.indexOf('<!--more-->') > 0) {
                    var parts = html.split(/\s*<\!\-\-more\-\->\s*/),
                            summary = parts.shift(),
                            details = parts.join('');

                    html = '<div class="summary">' + summary + '</div>'
                            + '<div class="details">' + details + '</div>';
                }


                var diffs = diffMatch.diff_main(last, html);
                last = html;

                if (diffs.length > 0) {
                    var stack = [], markStr = mark;

                    for (var i = 0; i < diffs.length; i++) {
                        var diff = diffs[i], op = diff[0], str = diff[1]
                        sp = str.lastIndexOf('<'), ep = str.lastIndexOf('>');

                        if (op != 0) {
                            if (sp >= 0 && sp > ep) {
                                if (op > 0) {
                                    stack.push(str.substring(0, sp) + markStr + str.substring(sp));
                                } else {
                                    var lastStr = stack[stack.length - 1], lastSp = lastStr.lastIndexOf('<');
                                    stack[stack.length - 1] = lastStr.substring(0, lastSp) + markStr + lastStr.substring(lastSp);
                                }
                            } else {
                                if (op > 0) {
                                    stack.push(str + markStr);
                                } else {
                                    stack.push(markStr);
                                }
                            }

                            markStr = '';
                        } else {
                            stack.push(str);
                        }
                    }

                    html = stack.join('');

                    if (!markStr) {
                        var pos = html.indexOf(mark), prev = html.substring(0, pos),
                                next = html.substr(pos + mark.length),
                                sp = prev.lastIndexOf('<'), ep = prev.lastIndexOf('>');

                        if (sp >= 0 && sp > ep) {
                            html = prev.substring(0, sp) + span + prev.substring(sp) + next;
                        } else {
                            html = prev + span + next;
                        }
                    }
                }

                return html;
            });

            editor.hooks.chain('onPreviewRefresh', function () {
                var diff = $('.diff', preview), scrolled = false;

                $('img', preview).load(function () {
                    if (scrolled) {
                        preview.scrollTo(diff, {
                            offset: -50
                        });
                    }
                });

                if (diff.length > 0) {
                    var p = diff.position(), lh = diff.parent().css('line-height');
                    lh = !!lh ? parseInt(lh) : 0;

                    if (p.top < 0 || p.top > preview.height() - lh) {
                        preview.scrollTo(diff, {
                            offset: -50
                        });
                        scrolled = true;
                    }
                }
            });

            var input = $('#text'), th = textarea.height(), ph = preview.height();

            editor.hooks.chain('enterFakeFullScreen', function () {
                th = textarea.height();
                ph = preview.height();
                $(document.body).addClass('fullscreen');
                var h = $(window).height() - toolbar.outerHeight();

                textarea.css('height', h);
                preview.css('height', h);
            });

            editor.hooks.chain('enterFullScreen', function () {
                $(document.body).addClass('fullscreen');

                var h = window.screen.height - toolbar.outerHeight();
                textarea.css('height', h);
                preview.css('height', h);
            });

            editor.hooks.chain('exitFullScreen', function () {
                $(document.body).removeClass('fullscreen');
                textarea.height(th);
                preview.height(ph);
            });

            editor.run();

            // 编辑预览切换
            var edittab = $('#md-button-bar').prepend('<div class="md-edittab"><label>上传<input type="file" id="upload"  style="display: none" value="上传"/></label><a href="#md-editarea" class="active">撰写</a><a href="#md-preview">预览</a></div>'),
                    editarea = $(textarea.parent()).attr("id", "md-editarea");

            $(".md-edittab a").click(function () {
                $(".md-edittab a").removeClass('active');
                $(this).addClass("active");
                $("#md-editarea, #md-preview").addClass("md-hidetab");

                var selected_tab = $(this).attr("href"),
                        selected_el = $(selected_tab).removeClass("md-hidetab");

                // 预览时隐藏编辑器按钮
                if (selected_tab == "#md-preview") {
                    $("#md-button-row").addClass("md-visualhide");
                } else {
                    $("#md-button-row").removeClass("md-visualhide");
                }

                // 预览和编辑窗口高度一致
                $("#md-preview").outerHeight($("#md-editarea").innerHeight());

                return false;
            });
            var i = 0;
            $('#upload').change(function () {
                if ($(this).val() != "") {
                    var formData = new FormData();
                    //1获取传入元素的val
                    var name = $(this).val();
                    //2获取files
                    var files = $(this)[0].files[0];
                    //3将name 和 files 添加到formData中，键值对形式
                    formData.append("upload_file", files);
                    formData.append("name", name);
                    $.ajax({
                        url: "/upload/uploadImg",
                        type: "post",
                        data: formData,
                        contentType: false,
                        processData: false,
                        success: function (result) {
                            i = parseInt(i) + parseInt(1);
                            if (result.isSuccess) {
                                console.log(result.path);
                                insertText(text, "![][" + i + "]\n" +
                                        "  [" + i + "]:  " + result.path);
                            }
                        }
                    })
                }
            })


            //在指定textarea光标处插入
            function insertText(obj, charvalue) {
                obj.focus();
                var leng = obj.value.length;

                if (typeof document.selection != "undefined") {
                    var r = document.selection.createRange();
                    r.text = charvalue;
                } else {
                    obj.value = obj.value.substr(0, obj.selectionStart) + charvalue + obj.value.substring(obj.selectionStart, leng);
                }
            }

            $('#publish').click(function () {
                submit('published');
            })

            $('#save').click(function () {
                insertText(text, 'qwe');
                //submit('save');
            })

            function submit(status) {
                var input = '<input type="hidden" name="status" value="' + status + '">';
                $('#form').append(input);
                $('#form').submit();
            }
        });
    </script>
    <style>
        .content-img {
            background: url(/img/article-img.jpg) repeat;
        }

    </style>

</head>

<body>
<#include "header.ftl" >
<div style="margin-left: 20%;width: 60%;margin-top: 15px">
    <form id="form" action="/article/submit" method="post">
        <div style="margin-top:1em">
            <input type="text" id="title" name="title" autocomplete="off" placeholder="主题" style="width: 100%"/>
            <textarea style="height: 400px" autocomplete="off" id="text" name="content"
                      class="markdown-textarea"></textarea>
        </div>
        <div style="line-height:24px;font-size:12px;color:#999;">&nbsp;&nbsp;&nbsp;&nbsp;MarkDown使用手册可参考：
            <a style="color:#666;text-decoration:none" href="http://www.ubuntu.com/markdown/">http://www.ubuntu.com/markdown/</a>
        </div>
        <div style=" margin-left: 85%">
            <button type="button" class="btn btn-success" id="publish">发布</button>
            <button type="button" class="btn btn-warning" id="save">保存</button>
        </div>
    </form>
</div>
<#include "footer.ftl" >
</body>
