package com.study.sqlsession;

import java.util.List;

public interface SqlSession {

    // 查询全部
    <E> List<E> selectList(String statementId,Object... params) throws Exception;

    // 查询一个
    <T> T selectOne(String statementId,Object... params) throws Exception;

}