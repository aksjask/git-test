package com.itheima.service.impl;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;

/**
 * 账户业务层实现类
 *曾经xml配置
 *   <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *      scope="', init-method="", destroy-method="">
 *      <property  name="", value=""/ref=""></property>
 *   </bean>
 *
 *     一: 用于创建对象
 *              类似 xml中<bean></bean>标签
 *            @Component:  类对象存入容器
 *            属性  value 用于指定bean的id 首字母改小写,默认当前类名
 *
 *
 *    二:  用于注入数据
 *              类似xml中<property></property>
 *           1. @Autowired
 *                 作用:自动安装类型注入. 唯一的bean对象和注入类型匹配 ,不是一对一否则,报错
 *                      一对多 accountService(accountService ok   accountService1 xx  accountService2xx)完全匹配
 *           2.@Qualifier
 *              作用:先按类注入,再按名称注入,在给类成员注入时,不能单独使用,
 *              但是在给方法参数注入时可以,,,配合@Autowired
 *              属性 value 指定注入bean的id
 *            3.@Resource
 *            作用:安置bean的id 直接使用
 *            属性:name 用于指定bean的id
 *           ==========以上三个只能用于bean类型,string和基本类型不能用,集合只能通过xml实现===========
 *
 *            @Value
 *            作用 :string和基本类型
 *            属性 : value 可以使用spel表达式
 *              SpEl 格式  ${表达式}
 *
 *
 *   三:    用于改变作用范围
 *              类似xml 中scope属性
 *
 *            @Scope
 *            作用:指定bean的范围
 *            属性  value 指定范围取值  singleton   prototype 单例多例
 *
 *      四:  和生命周期相关
 *              类似       init-method destroy-么挺厚的1
 *       @  PreDestroy  :指定销毁方法
 *       @PostConstruction :指定初始化
 *
 *
 *
 *
 *
 * @Component
 *     Controller   view
 *     Service     service
 *     Repository   dao层
 *
 *
 */
@Service("accountService")
//@Scope("prototype")//多例
public class AccountServiceImpl implements IAccountService {

/*@Autowired
@Qualifier("accountDao1")*/
@Resource(name="accountDao2")

   private IAccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }
@PostConstruct
    public void init(){
        System.out.println("初始化");
    }
@PreDestroy
    public void  destroy(){
        System.out.println("销毁");
    }


    public void saveAccount() {
       accountDao.saveAccount();

    }


}
