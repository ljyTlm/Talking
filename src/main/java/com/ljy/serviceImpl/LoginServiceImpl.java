package com.ljy.serviceImpl;

import com.ljy.service.LoginService;
import org.springframework.stereotype.Service;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
    @Override
    public String login() {
        return "home";
    }
}
