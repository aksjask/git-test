package com.itheima.ui;


import com.itheima.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
        as.saveAccount();
        //3.手动关闭容器
        ac.close();



//        //-------BeanFactory--------
//        Resource resource =new ClassPathResource("bean.xml");
//        BeanFactory factory= new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService) factory.getBean("accountService");
//        System.out.println(as);
//        as.saveAccount();

    }

    }

//单例
//com.itheima.service.impl.AccountServiceImpl@74a14482
//保存了账户
//1
//com.itheima.service.impl.AccountServiceImpl@74a14482
//保存了账户
//2
//com.itheima.service.impl.AccountServiceImpl@74a14482
//保存了账户
//3
//com.itheima.service.impl.AccountServiceImpl@74a14482
//保存了账户
//4
//com.itheima.service.impl.AccountServiceImpl@74a14482
//保存了账户
//5


//多例
//com.itheima.service.impl.AccountServiceImpl@74a14482
//        保存了账户
//        1
//        com.itheima.service.impl.AccountServiceImpl@1540e19d
//        保存了账户
//        1
//        com.itheima.service.impl.AccountServiceImpl@677327b6
//        保存了账户
//        1
//        com.itheima.service.impl.AccountServiceImpl@14ae5a5
//        保存了账户
//        1
//        com.itheima.service.impl.AccountServiceImpl@7f31245a
//        保存了账户
//        1