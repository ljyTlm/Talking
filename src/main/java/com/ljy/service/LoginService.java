package com.ljy.service;

import com.ljy.entities.UserEntity;

public interface LoginService {
    String login(String username, String password);

    UserEntity getUserByName(String username);

    String insertUser(UserEntity user);
}
