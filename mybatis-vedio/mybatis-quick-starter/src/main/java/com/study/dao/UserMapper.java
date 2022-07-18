package com.study.dao;

import com.study.pojo.User;

public interface UserMapper {

    User findById(int id);
}