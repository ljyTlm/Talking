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
<%--    <link rel="stylesheet" href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">--%>
    <style>
        video{
            position: fixed;
            right: 0px;
            bottom: 0px;
            height: 100%;
            width: 100%;
            object-fit:fill;
            /*加滤镜*/
            /*filter: blur(15px); //背景模糊设置 */
            /*-webkit-filter: grayscale(100%);*/
            /*filter:grayscale(100%); //背景灰度设置*/
            z-index:-11
        }
    </style>
</head>
<body>
    <video autoplay loop muted>
        <source src="video/back_index.mp4" type="video/mp4" />
    </video>
    <div class="input-group">
        <span class="input-group-addon">@</span>
        <input type="text" class="form-control" placeholder="twitterhandle">
    </div>
</body>
</html>
