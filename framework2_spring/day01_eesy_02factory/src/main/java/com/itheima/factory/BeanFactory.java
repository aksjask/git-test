package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean :重用组件
 * JavaBean >实体类
 *
 * 它就是创建Service和dao对象的
 *
 * 第一个:需要xml 配置Service和dao
 *    配置的内容 全限定类名 唯一标识(key value)
 * 读取xml ,反射创建对象
 * 可以是xml ,或properties
 */
public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //定义一个map ,存放对象,称为容器
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {

        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的对象流
//        FileInputStream in = new FileInputStream("");
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置中的所有keys
            Enumeration  keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把bean和value存入容器中
                beans.put(key,value);

            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }



//    /**
//     * 根据bean名称获取bean对象,单例
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName){
//
//
//
//        return beans.get(beanName);
//    }

    /**
     * 根据bean名称获取bean对象,多例
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
            Object bean = null;
            String beanpath = props.getProperty(beanName);
            try {
                bean = Class.forName(beanpath).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            return bean;
    }
}
