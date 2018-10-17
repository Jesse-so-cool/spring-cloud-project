<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Jesse">
    <meta name="viewport"
          content="width=device-width, initial-scale=1,  user-scalable=no">
    <title>Spring Boot</title>
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<#--<link href="${base}/css/main.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

    <style>
        .login-bg {
            background: url(/img/login-bg.png) 0 0 /*repeat*/;
            width: 100%;
            height: 100%;
        }

        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            /* Set the fixed height of the footer here */
            height: 60px;
            background-color: #f5f5f5;
        }

        .fa {
            display: inline-block;
            left: 18px;
            position: relative;
        }

        input[type="text"], input[type="password"] {
            padding-left: 26px;
        }

        .checkbox {
            padding-left: 21px;
        }
    </style>
    <script>
        $(function () {
            $('#username').focus();
            //alert("???");
            $('#register').click(function () {
                window.location.href = "/register";
            })
            $('#githubLogin').click(function () {
                window.location.href = "/githubLogin";
            })
            function jump() {
            }
        })
    </script>
</head>

<body class="login-bg " style="margin-top: 20%;">
<div class="form-horizontal col-sm-offset-5 col-sm-4 col-sm-offset-5">
    <form class="login-form " id="form" action="/login" method="post">
        <h3 align="left" style="margin-left: 35px">用户登录</h3>
        <div class="form-group form-inline ">
            <i class="fa fa-user fa-lg"></i>
            <input type="text" name="username" id="username" required class="has-success input-lg form-control"
                   placeholder="请输入账号"/>
        </div>
        <div class="form-group form-inline">
            <i class="fa fa-lock fa-lg"></i>
            <input type="text" name="password" required class=" has-success input-lg form-control" placeholder="请输入密码"/>
        </div>
        <div class="form-group ">
            <#if error.isPresent()>
                <p>The email or password you have entered is invalid, try again.</p>
            </#if>
            <button class="btn btn-success btn-lg" style="margin-left: 80px" id="register" type="button"
                    onclick="jump()">注册
            </button>
            <button class="btn btn-success btn-lg" type="submit">登录</button>
        <#--</div><div class="form-group ">
            <button class="btn btn-info btn-lg">注册</button>-->
        </div>
        <div class="form-group " style="margin-left: 2px">
            <h4 style="margin-left: 30px">第三方帐号登录</h4>
            <a id="githubAuthorizationUrl"
               href="https://github.com/login/oauth/authorize?client_id=51e1a48f18d8d9bda59c&state=xxx&redirect_uri=http://localhost:8088/oauth/github"
               class="github">
                <img src="/img/githublogo.jpg" class="img-thumbnail" style="width: 40;border-width:0;">
            </a>
        </div>
    </form>

</div>

</body>