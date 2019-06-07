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
 * 获取用户信息
 * @param e
 */
function getUserInfo(e) {
    var username = $(e).text();
    alert(username);
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
            html += "<div class='panel-footer'>时间:"+model.time+" id:"+model.ip
                html += "<div style='float: right'>";
                    if (model.name == "我"){
                        html += "<button type='button' class='text-danger btn btn-warning ' onclick='removeTalking("+model.id+")'><span style='color: black'>撤回</span></button>";
                    }else {
                        html += "<button type='button' class='btn btn-warning' onclick='removeTalking("+model.id+")'>删除</button>";
                    }
                html += "</div>";
                html += "<div style='clear: both;'></div>";
            html +="</div>"
        html += "</div>";
    return html;
}

/**
 * 插入聊天记录
 * @param obj
 */
function insertTalking(obj) {
    $("#talkList").append(getTalkingModel(obj));
}

/**
 * 删除指定id的聊天记录
 * @param id
 */
function removeTalking(id) {
    $("#talk_"+id).remove();
    $.post("../TalkingAction/removeTalking.do",{talkingId:id}, function () {

    });
}

/**
 * 发送信息
 */
function subText(){
    var text = $("#editor").val();
    if(!cheek.cheekString(text)){return;}

    $.post("../TalkingAction/sendText.do", {text: text}, function (data) {
        if (data == ""){
            alert("登录过期！请重现登录");
            $(window).attr("location", "../index.html");
            return;
        }
        var jsonObj =  data.parseJSON();
        jsonObj.name = "我";
        insertTalking(jsonObj);
    });
}

/**
 * 替换信息 方便发送
 * @param e
 */
function replaceText(e){
    var text = $(e).text();
    $("#editor").val(text);
}

$(function () {

});