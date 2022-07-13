package com.study.pojo;

import lombok.Data;

@Data
public class MappedStatement {

    /**
     * id 标识
     */
    private String id;

    /**
     * 参数值类型
     */
    private String parameterType;

    /**
     * 返回值类型
     */
    private String resultType;

    /**
     * sql 语句
     */
    private String sql;

}