package com.ljy.serviceImpl;

import com.ljy.dao.LoginDao;
import com.ljy.entity.User;
import com.ljy.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginDao loginDao;

    @Override
    public String login(String username, String password) {
        //return loginDao.login();
        User user = loginDao.getUserByName(username);
        if (user == null || !user.getPassword().equals(password)){
            return "login fail";
        }
        return "success";
    }
}
