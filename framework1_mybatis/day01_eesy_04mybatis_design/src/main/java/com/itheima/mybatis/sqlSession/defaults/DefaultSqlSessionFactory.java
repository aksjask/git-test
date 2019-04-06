package com.itheima.mybatis.sqlSession.defaults;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlSession.SqlSession;
import com.itheima.mybatis.sqlSession.SqlSessionFactory;
import com.itheima.mybatis.sqlSession.SqlSessionFactoryBuilder;

public class DefaultSqlSessionFactory extends SqlSessionFactoryBuilder implements SqlSessionFactory {

    private Configuration cfg;
    public  DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /**
     * 用于创建一个新的数据库操作对象
     * @return
     */
    public SqlSession openSession() {
        return null;
    }
}
