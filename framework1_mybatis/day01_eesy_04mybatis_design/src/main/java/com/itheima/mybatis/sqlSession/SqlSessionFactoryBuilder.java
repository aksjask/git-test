package com.itheima.mybatis.sqlSession;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import com.itheima.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节流数字来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactoryBuilder build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
