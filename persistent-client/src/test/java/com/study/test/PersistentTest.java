package com.study.test;

import com.study.io.Resources;
import com.study.pojo.User;
import com.study.sqlsession.SqlSession;
import com.study.sqlsession.SqlSessionFactory;
import com.study.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class PersistentTest {

    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("Tom");
        User userResult = sqlSession.selectOne("user.selectOne", user);
        System.out.println(userResult);

    }
}
