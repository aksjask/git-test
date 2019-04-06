package com.itheima.test;

import itheima.dao.IUserDao;
import itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的CRUD操作
 */
public class MybatisTest {

    private  InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before //用于在测试方法之前执行
    public  void init() throws Exception {
        //1.读取配置文件,生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
         sqlSession = factory.openSession();
        //4.获取dao的代理对象
         userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After  //用于在测试方法之后执行
    public  void  destory() throws Exception {
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    /**
     * 测试查询所有
     */
    @Test
    public  void  testFindAll() throws Exception {
       /* //1.读取配置文件,生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);*/
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }


}

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){

        User user = new User();
        user.setUsername("mybatis saveUser");
        user.setAddress("北京顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
      /*  //1.读取配置文件,生成字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.获取dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);*/


        //5.执行保存方法
        userDao.saveUser(user);
//        //6.释放资源
//        sqlSession.close();
//        in.close();

        //7.提交事务
        sqlSession.commit();
    }

}
