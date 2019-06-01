<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019-06-01
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <video autoplay loop muted>
        <source src="video/back_index.mp4" type="video/mp4" />
    </video>
    <table>
        <tr>
            <td>
                <input type="button" data-target="#loginModal" data-toggle="modal" name="login" class="form-control  bt-red" value="登录" />
            </td>
            <td>
                <input type="button" data-target="#registerModal" data-toggle="modal" name="register" class="form-control  bt-red" value="注册" />
            </td>
        </tr>
    </table>
    <!-- 登录弹窗 -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header blue">
                    登录
                </div>
                <div class="modal-body">
                    <input id="login_username" type="text" class="form-control" placeholder="请输入用户名"  />
                    <input id="login_passwd" type="password" class="form-control" placeholder="请输入密码" />
                </div>
                <div class="modal-footer">
                    <div class="form-control text-center" onclick="login()">登录</div>
                    <div class="form-control text-center" data-dismiss="modal"><div class="button"></div>取消</div>
                </div>
            </div>
        </div>
    </div>
    <!-- 注册弹窗 -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header blue">
                    注册
                </div>
                <div class="modal-body">
                    <input id="register_username" type="text" class="form-control" placeholder="请输入用户名" />
                    <input id="register_password" type="password" class="form-control" placeholder="请输入密码" />
                </div>
                <div class="modal-footer">
                    <div class="form-control text-center" onclick="register()">注册</div>
                    <div class="form-control text-center" data-dismiss="modal"><div class="button"></div>取消</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
