function getUserOnline() {
    $.post("../TalkingAction/getAllUserOnline.do",
        function(data){
            alert(data)
        }
    );
}