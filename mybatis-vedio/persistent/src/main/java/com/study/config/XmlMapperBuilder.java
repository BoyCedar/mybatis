package com.study.config;

import com.study.pojo.Configuration;
import com.study.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XmlMapperBuilder {

    private Configuration configuration;

    public XmlMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {
        Document read = new SAXReader().read(inputStream);
        Element rootElement = read.getRootElement();
        List<Element> list = rootElement.selectNodes("//select");
        String namespace = rootElement.attributeValue("namespace");
        for (Element element : list) {
            String id = element.attributeValue("id");
            String parameterType = element.attributeValue("parameterType");
            String resultType = element.attributeValue("resultType");
            String sql = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setParameterType(parameterType);
            mappedStatement.setResultType(resultType);
            mappedStatement.setSql(sql);
            String statementId = namespace + "." + id;
            configuration.getMappedStatementMap().put(statementId,mappedStatement);
        }

    }
}