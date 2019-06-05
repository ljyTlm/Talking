package com.ljy.serviceImpl;

import com.ljy.constant.LogicConstant;
import com.ljy.dao.UserDao;
import com.ljy.entities.UserEntity;
import com.ljy.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    UserDao userDao;

    @Override
    public String login(String username, String password) {
        //return userDao.login();
        UserEntity userEntity = userDao.getUserByName(username);
        if (userEntity == null || !userEntity.getPassword().equals(password)){
            return LogicConstant.FAIL;
        }
        return LogicConstant.SUCCESS;
    }
}
