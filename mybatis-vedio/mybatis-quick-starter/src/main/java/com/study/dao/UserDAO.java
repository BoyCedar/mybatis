package com.study.dao;

import com.study.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {

    List<User> findAll() throws IOException;

}