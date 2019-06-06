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