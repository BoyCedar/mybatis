package com.study.sqlsession;

import com.study.pojo.Configuration;
import com.study.pojo.MappedStatement;

import java.util.List;

public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params);
}