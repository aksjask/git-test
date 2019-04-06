package com.itheima.mybatis.io;

import java.io.InputStream;

public class Resources {
    /**
     * 工具传入的参数,获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
            return  Resources.class.getClassLoader().getResourceAsStream(filePath);

    }
}
