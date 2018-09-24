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
    <link rel="stylesheet" href="/css/common.css">
    <style>
        .content-img {
            background: url(/img/article-img.jpg) repeat;
        }


    </style>

    <script>
        $(function () {
            $('.Article').mouseenter(function () {
                $(this).css("background-color", "#FFFDD5");
            });
            $('.Article').mouseleave(function () {
                $(this).css("background-color", "white");
            })
            var root = window.document.location.href;
            root = root.substring(0, root.indexOf("index"));

            $('love').click(function () {

            })
        })
    </script>
</head>

<body>
<#include "header.ftl" >
<div style="margin-left: 20%;width: 60%; margin-top: 20;">
    <nav class="bottom-inline"
         style=" background-color:#fff;  display:-webkit-box; display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-ms-flex-pack:justify;  ">
        <h5 class="hot">热门文章</h5>
        <ul class="nav nav-pills pull-left hot">
            <li roleEnum="presentation"><a href="/">推荐</a></li>
            <li roleEnum="presentation"><a href="AA">AA</a></li>
            <li roleEnum="presentation"><a href="BB">BB</a></li>
            <li roleEnum="presentation"><a href="CC">CC</a></li>
        </ul>
    </nav>
    <ul>
        <#list map.articleList.list as article>
            <li class="bottom-inline">
                <div class="content-box article">
                    <div>
                        <div>
                            <a href="/article/${article.id}">
                                <h3>${article.title}</h3>
                            </a>
                        </div>
                        <div>
                            <span class="label label-warning">标签1</span>
                            <span>${article.username}</span>
                            <span>${article.deployDate}</span>
                            <span>${article.viewCount}</span>
                            <span class="glyphicon glyphicon-heart" aria-hidden="true" id="love"></span>
                        </div>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
    <div class="page-footer">
        <nav aria-label="Page navigation" style="margin-left: auto;margin-right: auto;width: 250px;">
            <ul class="pagination">
                <li>
                    <a href="/index?pageNo=${map.articleList.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <#if !map.articleList.isFirstPage>
                    <li><a href="/index?pageNo=${map.articleList.pageNum-1}">${map.articleList.pageNum-1}</a></li>
                </#if>
                <li><a href="/index?pageNo=${map.articleList.pageNum}" class="active">${map.articleList.pageNum}</a>
                </li>
                <#if !map.articleList.isLastPage>
                <li><a href="/index?pageNo=${map.articleList.pageNum+1}">${map.articleList.pageNum+1}</a></li>
                </#if>
                <li>
                    <a href="/index?pageNo=${map.articleList.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

</div>
<#--<#include "footer.ftl" >-->
</body>
