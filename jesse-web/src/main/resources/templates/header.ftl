<head>
<#--
    <meta charset="utf-8">
    <meta name="author" content="Jesse">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maxium-scale=1,minimum-scale=1, user-scalable=no">
    <title>header</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
-->

    <style>
        .logo {
            background: url(/img/cp.jpg);
        }
    </style>
    <script>
        $(function () {
            $('#write').click(function () {
                writeArticle();
            })

            function writeArticle() {
                window.location.href = "/edit";
            }
        })
    </script>
</head>
<body>
<div class="header clearfix" style="position:relative;width: 100%;height: 84px">
    <div style="margin-left: 20%;height: 100%;width: 60%;">
        <div>
            <a href="/index">
                <img src="/img/jesse's logo.jpg" class="img-thumbnail" style="width: 105;border-width:0;"/>
            </a>
            <nav style="margin-top: -48px;">
                <ul class="nav nav-tabs pull-right">
                    <li>
                        <button type="button" id="write" class="btn btn-primary btn-lg" <#--onclick="writeArticle()"-->>
                            写文章
                        </button>
                    </li>
                    <li>
                    <#--<form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>-->
                        <form class="navbar-form navbar-left" role="search">
                            <div>
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="搜索些什么...">
                                    <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">搜索</button>
                                    </span>
                                </div><!-- /input-group -->
                            </div>
                        </form>
                    </li>
                <#--<li roleEnum="presentation" class><a href="/">主页</a></li>
                <li roleEnum="presentation"><a href="/logout">注销</a></li>-->
                </ul>
            </nav>
        </div>

    </div>


</div>
</body>