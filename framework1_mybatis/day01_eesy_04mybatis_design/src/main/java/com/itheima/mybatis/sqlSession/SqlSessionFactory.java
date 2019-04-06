package com.itheima.mybatis.sqlSession;

public interface SqlSessionFactory {
    /**
     * 用于创建一个新的session对象
     */
      SqlSession openSession();
}
