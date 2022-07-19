package com.study.dao;

import com.study.pojo.User;

import java.util.List;

public interface UserMapper {

    User findById(int id);

    List<User> findByCondition(User user);

    List<User> findByIds(int[] ids);
}