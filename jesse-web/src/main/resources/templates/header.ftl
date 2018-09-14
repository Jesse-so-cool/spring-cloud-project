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
</head>
<body>
<div class="header clearfix" style="position:relative;width: 100%;height: 84px">
    <div style="margin-left: 20%;height: 5rem;width：60%">
        <a href="index">
            <img src="/img/jesse's logo.jpg" class="img-thumbnail" style="width: 105;border-width:0;"/>
        </a>
    </div>
    <nav style="margin-right: 20%;margin-top: -18px;">
        <ul class="nav nav-tabs pull-right">
            <li roleEnum="presentation"><a href="/">主页</a></li><#--
            <li roleEnum="presentation"><a href="login">登陆</a></li>
            <li roleEnum="presentation"><a href="admin">注册</a></li>-->
            <li roleEnum="presentation"><a href="/logout">注销</a></li>
            <li roleEnum="presentation"><a href="/about">关于我们</a></li>
        </ul>
    </nav>


</div>
</body>