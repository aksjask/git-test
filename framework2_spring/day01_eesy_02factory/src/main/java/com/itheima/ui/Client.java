package com.itheima.ui;



import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层,调用业务层
 */
public class Client {
    public static void main(String[] args) {
     IAccountService as = new AccountServiceImpl();



            System.out.println(as);
            as.saveAccount();


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