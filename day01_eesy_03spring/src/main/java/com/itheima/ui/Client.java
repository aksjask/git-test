package com.itheima.ui;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层,调用业务层
 */

public class Client {
    /**
     * 获取spring的核心容器,并根据id获取  对象
     *
     *  ApplicationContext三个常用实现类
     *          ClassPathXmlApplicationContext   加载类路径下的配置文件
     *           FileSystemXmlApplicationContext  加载磁盘任意文件
     *           AnnotationConfigApplicationContext  读取注解创建容器
     *
     *
     *1. ApplicationContext  单例模式
     *    创建核心容器时,立即加载
     *    只要一读取xml立即创建xml中配置的对象
     * 2.BeanFactory          多例模式
     *
     * @param args
     */

    public static void main(String[] args) {
      /*//  IAccountService as = new AccountServiceImpl();
        //1.获取核心容器对象
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
      //  ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\WorkExe\\java_practise\\day01_eesy_03spring\\src\\main\\resources\\bean.xml");
        //2根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println("bean对象accountService:"+as);
        System.out.println("bean对象accountDao:"+adao);


        System.out.println(as);
        as.saveAccount();
*/


      //-------BeanFactory--------
        Resource resource =new ClassPathResource("bean.xml");
        BeanFactory factory= new XmlBeanFactory(resource);
        IAccountService as1= (IAccountService) factory.getBean("accountService");
        IAccountService as2 = (IAccountService) factory.getBean("accountService");
        System.out.println(as1);
        System.out.println(as2);
        System.out.println(as1==as2);

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