package com.study.sqlsession;

import com.study.config.XmlConfigBuilder;
import com.study.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) throws PropertyVetoException, DocumentException {
        //第一步：使用dom4j 解析配置文件，将解析出来的内容封装到Configuration中
        XmlConfigBuilder configBuilder = new XmlConfigBuilder();
        Configuration configuration = configBuilder.parseConfig(inputStream);

        //第二步：创建 SqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return sqlSessionFactory;
    }
}