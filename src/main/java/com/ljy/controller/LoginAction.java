package com.ljy.controller;

import com.ljy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/LoginAction")
public class LoginAction {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody String login(){
        return loginService.login();
    }
}
