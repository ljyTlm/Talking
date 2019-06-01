package com.ljy.dao;

import com.ljy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {

    User getUserById(@Param("id") int id);

    User getUserByName(@Param("username") String username);
}
