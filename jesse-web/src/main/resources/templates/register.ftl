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
            $('#phone').focus();
            $('#getVerificationCode').hide();
            //alert("???");
            $('#register').click(function () {
                window.location.href = "/register";
            })
            $('#getVerificationCode').click(function () {
                $.ajax({
                    type: "POST",
                    url: "/thirdparty/sendMessage",
                    data: {
                        "phone": $("#phone").val()
                    },
                    success: function () {
                        $('#get').attr('disabled', 'disabled');
                        $('#get').html("已发送");
                    }
                })
            })
            $('#phone').change(function () {
                number11();
            })

            function number11() {
                if ($('#phone').val().length == 11) {
                    $('#getVerificationCode').show();
                }
            }
        })
    </script>
</head>

<body class="login-bg " style="margin-top: 20%;">
<div class="form-horizontal col-sm-offset-5 col-sm-4 col-sm-offset-5">
    <form class="login-form " id="form" action="/register/submitRegister" method="post">
        <h3 align="left" style="margin-left: 35px">用户注册</h3>
        <div class="form-group form-inline ">
            <i class="fa fa-user fa-lg"></i>
            <input type="text" name="phone" id="phone" required class="has-success input-lg form-control"
                   placeholder="请输入手机..."/>
        </div>
        <div class="form-group form-inline">
            <i class="fa fa-user fa-lg"></i>
            <input type="text" name="verificationCode" required class=" has-success input-lg form-control"
                   placeholder="请输入验证码"/>
            <span class="input-group-btn" id="getVerificationCode">
                                    <button class="btn btn-default" type="button" id="get">获取验证码</button>
                                    </span>
        </div>
        <div class="form-group form-inline">
            <i class="fa fa-lock fa-lg"></i>
            <input type="text" name="password" required class=" has-success input-lg form-control" placeholder="请输入密码"/>
        </div>
        <div class="form-group ">
            <#if error!=''>
                <div class="alert alert-danger" role="alert" style="width: 29%;margin-left: 8;">${error}</div>
            </#if>
            <button class="btn btn-success btn-lg" style="margin-left: 130px" id="register" type="submit">注册</button>
        <#--</div><div class="form-group ">
            <button class="btn btn-info btn-lg">注册</button>-->
        </div>
    </form>

</div>

</body>