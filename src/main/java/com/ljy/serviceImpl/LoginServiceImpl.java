package com.ljy.serviceImpl;

import com.ljy.dao.LoginDao;
import com.ljy.entity.User;
import com.ljy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginDao loginDao;

    @Override
    public String login() {
        //return loginDao.login();
        User user = loginDao.getUserById(1);
        return user.toString();
    }
}
