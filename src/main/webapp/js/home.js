/**
 * 获取所有的在线用户
 */
function getUserOnline() {
    $.post("../TalkingAction/getAllUserOnline.do",
        function(data){
            setTimeout("getUserOnline()", 60000);
        });
}

/**
 * 制作聊天记录模板
 * @param model
 * @returns {string}
 */
function getTalkingModel(model){
    var html = "<div id='talk_"+model.id+"' class='panel panel-success'>";
            html += "<div class='panel-heading'>"+model.name+"</div>";
            html += "<div class='panel-body'>"+model.text+"</div>";
            html += "<div class='panel-footer'>时间:"+model.time+" id:"+model.ip+"</div>"
        html += "</div>";
    return html;
}

/**
 * 发送信息
 */
function subText(){
    var text = $("#editor").val();
    if(cheek.cheekString(text)){return;}

    $.post("../TalkingAction/sendText.do", {text: text}, function (data) {
        if (data == "fail"){
            alert("登录过期！请重现登录");
            $(window).attr("location", "../index.html");
        }
        $("#talkList").append(getTalkingModel(data.parseJSON()));
    });
}

$(function () {

});