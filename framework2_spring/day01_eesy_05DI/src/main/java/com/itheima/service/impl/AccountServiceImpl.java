package com.itheima.service.impl;


import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * 账户业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    private  String name;
    private  Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        //如果是经常变化的数据,不适合依赖注入
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了...."+name+age+birthday);

    }


}
