/**
 * 获取所有的在线用户
 */
function getUserOnline() {
    $.post("../TalkingAction/getAllUserOnline.do",
        function(data){
            var list = JSON.parse(data);
            var html = "";
            for (var i = 0; i < list.length; i ++){
                html += "<li><a onclick='getUserInfo(this)'>"+list[i].username+"</a></li>";
            }
            $("#userOnline").html(html);
            setTimeout("getUserOnline()", 60000);
        });
}

/**
 * 获取用户信息
 * @param e
 */
function getUserInfo(e) {
    var username = $(e).text();
    $.post("../TalkingAction/getUserInfo.do", {username:username}, function (user) {
        alert("哈哈 先这么看吧\n"+user);
    });
}

/**
 * 制作聊天记录模板
 * @param model
 * @returns {string}
 */
function getTalkingModel(model){
    var html = "<div id='talk_"+model.id+"' class='panel panel-success back-discolor1'>";
            html += "<div class='panel-heading '>"+model.username+"</div>";
            html += "<div class='panel-body'>"+model.text+"</div>";
            html += "<div class='panel-footer back-discolor8'>时间:"+model.time+" id:"+model.ip
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
 * 刷新聊天记录
 */
function refreshTalking() {
    $.post("../TalkingAction/refreshTalking.do", function (data) {
        var list = JSON.parse(data);
        var map = [];
        for(var i = 0; i < list.length; i ++){
            map["talk_"+list[i].id] = 1;
        }
        var talk = $("div[id^='talk_']");
        var removeIdList = [];
        for(var i = 0; i < talk.length; i ++){
            var id = $(talk[i]).attr("id");
            if(map[id] != 1){
                removeIdList.push(id);
            }
        }
        for(var i = 0; i < removeIdList.length; i ++){
            $("#"+removeIdList[i]).remove();
        }
        map = [];
        talk = $("div[id^='talk_']");
        for(var i = 0; i < talk.length; i ++){
            var id = $(talk[i]).attr("id");
            map[id] = 1;
        }
        for(var i = 0; i < list.length; i ++){
            if(map["talk_"+list[i].id] != 1){
                insertTalking(list[i]);
            }
        }
        setTimeout("refreshTalking()", 500);
    });
}

/**
 * 删除指定id的聊天记录
 * @param id
 */
function removeTalking(id) {
    $("#talk_"+id).remove();
    $.post("../TalkingAction/removeTalking.do",{id:id});
}

/**
 * 替换信息 方便发送
 * @param e
 */
function replaceText(e){
    var text = $(e).text();
    $("#editor").val(text);
}

/**
 * 插入上一条发送过的信息 功能方便强大！
 */
function insertLastText(text) {
    $("#lastText").text(text);
}

/**
 * 发送信息
 */
function subText(){
    var text = $("#editor").val();
    if(!check.checkString(text)){return;}

    $.post("../TalkingAction/sendText.do", {text: text}, function (data) {
        if (data == ""){
            alert("登录过期！请重现登录");
            $(window).attr("location", "../index.html");
            return;
        }
        var jsonObj =  JSON.parse(data);
        jsonObj.name = "我";
        insertTalking(jsonObj);
        insertLastText(text);
    });
}

$(function () {
    getUserOnline();
    refreshTalking();
});