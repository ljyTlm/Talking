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

var cheek = {

    cheekUsername : function (name) {
        if (name.length < 2 || name.length > 10){
            alert("名字长度过短或过长！");
            return false;
        }
        return true;
    },

    cheekEmail : function (email) {
        if(email.indexOf("@") == -1){
            alert("请输入正确的邮箱地址！");
            return false;
        }
        return true;
    },

    cheekString : function (str, flag) {
        if (flag == 1){
            for (var i = 0; i < str.length; i ++){
                if(str[i] < "a" || str[i] > "z") {
                    alert("请输入小写字母！");
                    return false;
                }
            }
        }
        return true;
    },

    cheekPhone: function (phone) {
        if (phone.length == 7 || phone.length == 11) {
            return true;
        }
        alert("请输入正确的电话号码！");
        return false;
    }
}

function register() {
    console.log("注册");
    var username = $("#register_username").val();
    if(!cheek.cheekUsername(username)) return;

    var password_1 = $("#register_password_1").val();
    var password_2 = $("#register_password_2").val();

    var sign = $("#register_sign").val();
    if(!cheek.cheekString(sign, 1)) return;

    var email = $("#register_email").val();
    if(!cheek.cheekEmail(email)) return;

    var phone = $("#register_phone").val();
    if(!cheek.cheekPhone(phone)) return;

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