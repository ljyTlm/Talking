package com.ljy.controller;


import com.alibaba.fastjson.JSON;
import com.ljy.entities.ChatRecordEntity;
import com.ljy.entities.UserEntity;
import com.ljy.service.TalkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("TalkingAction")
public class TalkingAction extends BaseAction{

    @Autowired
    TalkingService talkingService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "getAllUserOnline.do")
    @ResponseBody String getAllUserOnline(HttpServletRequest request){
        List<UserEntity> users = new ArrayList<UserEntity>();
        List<HttpSession> list = (List<HttpSession>)servletContext.getAttribute("users");
        for(int i = 0; i < list.size(); i ++){
            String username = (String)list.get(i).getAttribute("username");
            if (username != null){
                UserEntity user = new UserEntity();
                user.setUsername(username);
                users.add(user);
            }
        }
        return JSON.toJSONString(users);
    }

    @RequestMapping(value = "getUserInfo.do")
    @ResponseBody String getUserInfo(HttpServletRequest request){
        String username = getParm(request, "username");
        UserEntity user = talkingService.getUserInfo(username);
        return JSON.toJSONString(user);
    }

    @RequestMapping(value = "removeTalking.do")
    void removeTalking(HttpServletRequest request){
        String username = getSession(request, "username");
        String id = getParm(request, "id");
        talkingService.removeTalking(Integer.parseInt(id), username);
    }


    @RequestMapping(value = "sendText.do")
    @ResponseBody String sendText(HttpServletRequest request){
        ChatRecordEntity chatRecordEntity = new ChatRecordEntity();
        String text = getParm(request, "text");
        chatRecordEntity.setText(text);
        String ip = request.getRemoteAddr();
        chatRecordEntity.setIp(ip);
        String username = getSession(request, "username");
        chatRecordEntity.setUsername(username);
        return JSON.toJSONString(talkingService.insertChatRecord(chatRecordEntity));
    }

}
