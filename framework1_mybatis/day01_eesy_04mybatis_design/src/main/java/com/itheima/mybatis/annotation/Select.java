package com.itheima.mybatis.annotation;

import com.itheima.domain.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * 查询的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select  {

    /**
     * 配置sql语句的
     * @return
     */
    String value();
}
