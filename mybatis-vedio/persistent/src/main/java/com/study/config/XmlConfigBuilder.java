package com.study.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.io.Resources;
import com.study.pojo.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XmlConfigBuilder {

    private Configuration configuration;

    public XmlConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * 该方法就是使用dom4j 对配置文件进行解析，封装Configuration
     */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Element> list = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name,value);
        }
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driver"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("url"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));
        configuration.setDataSource(comboPooledDataSource);

        XmlMapperBuilder xmlMapperBuilder = new XmlMapperBuilder(configuration);

        //mapper.xml 解析，拿到路径 -》 字节输入流 -》 dom4j 进行解析
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element : mapperList) {
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            xmlMapperBuilder.parse(resourceAsStream);
        }

        return configuration;
    }
}