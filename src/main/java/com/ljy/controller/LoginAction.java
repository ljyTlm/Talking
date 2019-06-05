package com.ljy.controller;

import com.ljy.constant.LogicConstant;
import com.ljy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/LoginAction")
public class LoginAction extends BaseAction{

    @Autowired
    LoginService loginService;

    @RequestMapping("/login.do")
    @ResponseBody String login(HttpServletRequest rq, HttpServletResponse rp){
        String username = getParm(rq, "username");
        String password = getParm(rq, "password");
        String result = loginService.login(username, password);
        if (result.equals(LogicConstant.SUCCESS)){
            setSession(rq, "username", username);
        }
        return result;
    }
}
