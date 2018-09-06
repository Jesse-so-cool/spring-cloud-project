<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Jesse">

    <title>Jesse的主页</title>
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<#--<link href="${base}/css/main.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <style>
        .content-img {
            background: url(/web/static/img/article-img.jpg) repeat;
        }

        body {
            background-color: #f4f5f5;
        }

        div {
            background-color: white;
        }
    </style>
</head>

<body>
<#include "header.ftl" >
<div style="margin-left: 200px;width: 70%;margin-top: 15px">
    <nav>
        <h5>热门文章</h5>
        <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="/">推荐</a></li>
            <li role="presentation"><a href="AA">AA</a></li>
            <li role="presentation"><a href="BB">BB</a></li>
            <li role="presentation"><a href="CC">CC</a></li>
        </ul>
    </nav>
    <h3>hello world</h3>
</div>
<#include "footer.ftl" >
</body>
