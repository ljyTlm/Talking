function login() {
    console.log("登录");
    var username = $("#login_username").val();
    var password = $("#login_password").val();
    $.post("LoginAction/login.do",
        {username:username, password:password},
        function (data) {
            if (data == "success"){
                $(window).attr('location','html/home.jsp');
            }else {
                alert("用户名或密码错误！");
            }
        });
}
function regist() {
    console.log("注册");
}