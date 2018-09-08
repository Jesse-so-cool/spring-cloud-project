<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Jesse">

    <title>Jesse的主页</title>
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<#--<link href="${base}/css/main.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
    <#--integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"--> crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/web/css/common.css">
    <style>
        .content-img {
            background: url(/web/img/article-img.jpg) repeat;
        }


    </style>

    <script>
        $(function () {
            $('.article').mouseenter(function () {
                $(this).css("background-color", "#FFFDD5");
            });
            $('.article').mouseleave(function () {
                $(this).css("background-color", "white");
            })
        })
    </script>
</head>

<body>
<#include "header.ftl" >
<div style="margin-left: 20%;width: 60%;margin-top: 15px">
    <nav class="bottom-inline"
         style=" background-color:#fff;  display:-webkit-box; display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-ms-flex-pack:justify;  ">
        <h5 class="hot">热门文章</h5>
        <ul class="nav nav-pills pull-left hot">
            <li role="presentation"><a href="/">推荐</a></li>
            <li role="presentation"><a href="AA">AA</a></li>
            <li role="presentation"><a href="BB">BB</a></li>
            <li role="presentation"><a href="CC">CC</a></li>
        </ul>
    </nav>
    <ul>
        <li class="bottom-inline">
            <div class="content-box article">
                <div>
                    <div>
                        <a href="#">
                            <h3>hello world</h3>
                        </a>
                    </div>
                    <div>
                        <span class="label label-warning">标签1</span>
                        <span>Jesse</span>
                        <span>·2days</span>
                    </div>
                </div>
            </div>
        </li>
        <li class="bottom-inline">
            <div class="content-box article">
                <div>
                    <div>
                        <a href="#">
                            <h3>hello world</h3>
                        </a>
                    </div>
                    <div>
                        <span class="label label-success">标签2</span>
                        <span>Jesse</span>
                        <span>·2days</span>
                    </div>
                </div>
            </div>
        </li>
        <li class="bottom-inline">
            <div class="content-box article">
                <div>
                    <div>
                        <a href="#">
                            <h3>hello world</h3>
                        </a>
                    </div>
                    <div>
                        <span class="label label-danger">标签2</span>
                        <span>Jesse</span>
                        <span>·2days</span>
                    </div>
                </div>
            </div>
        </li>
        <li class="bottom-inline">
            <div class="content-box article">
                <div>
                    <div>
                        <a href="#">
                            <h3>hello world</h3>
                        </a>
                    </div>
                    <div>
                        <span class="label label-info">标签2</span>
                        <span>Jesse</span>
                        <span>·2days</span>
                    </div>
                </div>
            </div>
        </li>
        <li class="bottom-inline">
            <div class="content-box article">
                <div>
                    <div>
                        <a href="#">
                            <h3>hello world</h3>
                        </a>
                    </div>
                    <div>
                        <span class="label label-primary">标签2</span>
                        <span>Jesse</span>
                        <span>·2days</span>
                    </div>
                </div>
            </div>
        </li>
    </ul>
    <div class="page-footer">
        <nav aria-label="Page navigation" style="margin-left: auto;margin-right: auto;width: 250px;">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#" class="active">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>
<#include "footer.ftl" >
</body>