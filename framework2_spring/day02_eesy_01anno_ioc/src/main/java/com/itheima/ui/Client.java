package com.itheima.ui;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层,调用业务层
 */

public class Client {
    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        //1.获取核心容器对象
         ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象

        IAccountService as = (IAccountService) ac.getBean("accountService");
        System.out.println(as);
        as.saveAccount();

        ac.close();

//        IAccountDao aDao =  ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(aDao);


    }

    }
