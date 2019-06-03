package com.ljy.dao;

import com.ljy.entities.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    UserEntity getUserById(@Param("id") int id);

    UserEntity getUserByName(@Param("username") String username);
}
