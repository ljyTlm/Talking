function login() {
    console.log("登录");
    var username = $("#login_username").val();
    var password = $("#login_password").val();
    $.post("LoginAction/login.do",
        {username:username, password:password},
        function (data) {
            if (data == "success"){
                $(window).attr('location','html/home.html');
            }else {
                alert("用户名或密码错误！");
            }
        });
}

function register() {

    console.log("注册");
    var username = $("#register_username").val();
    if(!check.checkUsername(username)) return;

    var password_1 = $("#register_password_1").val();
    var password_2 = $("#register_password_2").val();

    var sign = $("#register_sign").val();
    if(!check.checkString(sign, 1)) return;

    var email = $("#register_email").val();
    if(!check.checkEmail(email)) return;

    var phone = $("#register_phone").val();
    if(!check.checkPhone(phone)) return;

    if (password_1 != password_2){
        alert("请重新输入密码");
        return;
    }

    var user = {
        username : username,
        password : password_1,
        sign : sign,
        email : email,
        phoneNumber : phone
    }

    $.post("LoginAction/register.do", {user:JSON.stringify(user)},
        function (data) {
            if (data == "success"){
                alert("注册成功！请登录")
            }else {
                alert("用户名或密码错误！");
            }
        });
}