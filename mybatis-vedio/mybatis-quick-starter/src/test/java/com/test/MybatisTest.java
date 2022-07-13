package com.test;

import com.study.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void test() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印结果
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
}
