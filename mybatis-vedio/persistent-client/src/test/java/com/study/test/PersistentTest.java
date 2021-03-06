package com.study.test;

import com.study.dao.IUserDao;
import com.study.io.Resources;
import com.study.pojo.User;
import com.study.sqlsession.SqlSession;
import com.study.sqlsession.SqlSessionFactory;
import com.study.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class PersistentTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("Tom");
        User userResult = sqlSession.selectOne("user.selectOne", user);
        System.out.println(userResult);

        List<User> userList = sqlSession.selectList("user.selectList");
        System.out.println(userList);


        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        User userMapper = new User();
        userMapper.setUsername("Tom");
        userMapper.setId(2);
        User userMapperResult = userDao.findByCondition(user);
        System.out.println(userMapperResult);

        List<User> all = userDao.findAll();
        System.out.println(all);

    }
}
