package com.study.dao;

import com.study.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> findAll() throws IOException {
        // 1. Resources 工具类，配置文件的加载，把配置文件加载成字节输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 解析了配置文件，并创建了 sqlSessionFactory 工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 生产 sqlSession，默认开启一个事务，但是该事务不会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4. 在进行增删改操作时，要手动提交事务
        // sqlSession 调用方法：查询所有:selectList 查询单个:selectOne  添加:insert  修改:update  删除:delete
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        sqlSession.close();

        return userList;
    }
}
