<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="author" content="Jesse">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maxium-scale=1,minimum-scale=1, user-scalable=no">
    <title>Spring Boot</title>
    <link href="//cdn.jsdelivr.net/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<#--<link href="${base}/css/main.css" rel="stylesheet">-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <style>
        .login-bg {
            background: url(/web/img/login-bg.png) 0 0 /*repeat*/;
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

        /*.container {
            width: auto;
            max-width: 680px;
            padding: 0 15px;
        }
        .container .text-muted {
            margin: 20px 0;
        }*/

        /*.center-in-center {
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }*/
        /*.form{background: rgba(255,255,255,0.2);width:400px;margin:120px auto;}*/

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
</head>

<body class="login-bg " style="margin-top: 20%;">
<div class="form-horizontal col-sm-offset-5 col-sm-4 col-sm-offset-5">
    <form class="login-form " action="" method="post" autocomplete="off">
        <h3 align="left" style="margin-left: 35px">用户登录</h3>
        <div class="form-group form-inline ">
            <i class="fa fa-user fa-lg"></i>
            <input type="text" class="has-success input-lg form-control" placeholder="请输入账号"/>
        </div>
        <div class="form-group form-inline">
            <i class="fa fa-lock fa-lg"></i>
            <input type="text" class=" has-success input-lg form-control" placeholder="请输入密码"/>
        </div>
        <div class="form-group ">
            <button class="btn btn-success btn-lg" style="margin-left: 130px">登录</button>
        <#--</div><div class="form-group ">
            <button class="btn btn-info btn-lg">注册</button>-->
        </div>
    </form>
</div>

</body>