package com.itheima.test;


import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;

import com.itheima.mybatis.io.Resources;
import com.itheima.mybatis.sqlSession.SqlSession;
import com.itheima.mybatis.sqlSession.SqlSessionFactory;
import com.itheima.mybatis.sqlSession.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
//        1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = (SqlSessionFactory) builder.build(in);
        //3.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
       /* //3.使用工厂创建dao的对象
        UserDaoImpl userDao = new UserDaoImpl(factory);
*/
        //4.使用SqlSession创建dao接口的代理实现对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5.使用代理对象实现方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();


    }
}
