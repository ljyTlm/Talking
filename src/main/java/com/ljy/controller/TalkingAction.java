package com.ljy.controller;


import com.alibaba.fastjson.JSON;
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
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("TalkingAction")
public class TalkingAction {

    @Autowired
    TalkingService talkingService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "getAllUserOnline.do", produces = "text/plain;charset=UTF-8")
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

}
