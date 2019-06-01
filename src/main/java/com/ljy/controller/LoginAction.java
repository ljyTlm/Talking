package com.ljy.controller;

import com.ljy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/LoginAction")
public class LoginAction extends BaseAction{

    @Autowired
    LoginService loginService;

    @RequestMapping("/login.do")
    @ResponseBody String login(HttpServletRequest rq){
        String username = getParm(rq, "username", String.class);
        String password = getParm(rq, "password", String.class);
        return loginService.login(username, password);
    }
}
