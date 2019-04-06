package com.itheima.mybatis.sqlSession.defaults;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.sqlSession.Proxy.MapperProxy;
import com.itheima.mybatis.sqlSession.SqlSession;
import com.itheima.mybatis.sqlSession.SqlSessionFactory;

import java.lang.reflect.Proxy;


/**
 *
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    public  DefaultSqlSession(Configuration cfg){
        this.cfg=cfg;

    }


    /**
     * 创建代理对象
     * @param daoInterfaceClass  dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {

        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers())
         );
        return null;
    }

    /**
     * 用于释放资源
     */
    public void close() {

    }
}
