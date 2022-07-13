package com.study.pojo;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Data
public class Configuration {

    private DataSource dataSource;

    /**
     * key：statementId  value:封装好的 MappedStatement 对象
     */
    Map<String,MappedStatement> mappedStatementMap = new HashMap<>();
}
