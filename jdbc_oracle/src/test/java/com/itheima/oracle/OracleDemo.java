package com.itheima.oracle;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.oracore.OracleTypeNUMBER;
import org.junit.Test;

import java.sql.*;

public class OracleDemo {
    @Test
    public void javaCallOracle() throws Exception {
        //加载数据库驱动
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@192.168.79.10:1521:orcl";
//        String username = "scott";
//        String password = "tiger";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.128:1521:xe", "itheima", "itheima");
        //得到预编译的Statement的对象
        PreparedStatement pstm = connection.prepareStatement("SELECT  *  FROM  emp where empno = ?");
        //给参数赋值
        pstm.setObject(1, 7788);
        //执行数据库查询操作
        ResultSet rs = pstm.executeQuery();
        //输出结果
        while (rs.next()) {
            System.out.println(rs.getString("ename"));
        }

        //释放资源
        rs.close();
        pstm.close();
        connection.close();
    }

    /**
     * java调用存储过程
     * @throws Exception
     */
    @Test
    public void javaCallProcedure() throws Exception {
        //加载数据库驱动
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@192.168.79.10:1521:orcl";
//        String username = "scott";
//        String password = "tiger";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.128:1521:xe", "itheima", "itheima");
        //得到预编译的Statement的对象
        CallableStatement pstm = connection.prepareCall("{call p_yearsal(? ,?)}");
        //给参数赋值
        pstm.setObject(1, 7788);
        pstm.registerOutParameter(2, OracleTypes.NUMBER);
        //执行数据库查询操作
       // ResultSet rs = pstm.executeQuery();

        pstm.execute();
        //输出结果
//        while (rs.next()) {
//            System.out.println(rs.getString("ename"));
//        }
        System.out.println(pstm.getObject(2));

        //释放资源
        //rs.close();
        pstm.close();
        connection.close();
    }


    /**
     * java调用存储函数
     * @throws Exception
     */
    @Test
    public void javaCallFunction() throws Exception {
        //加载数据库驱动
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@192.168.79.10:1521:orcl";
//        String username = "scott";
//        String password = "tiger";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.128:1521:xe", "itheima", "itheima");
        //得到预编译的Statement的对象
        CallableStatement pstm = connection.prepareCall("{?=call f_yearsal(?)}");
        //给参数赋值
        pstm.setObject(2, 7788);
        pstm.registerOutParameter(1, OracleTypes.NUMBER);
        //执行数据库查询操作
        // ResultSet rs = pstm.executeQuery();

        pstm.execute();
        //输出结果
//        while (rs.next()) {
//            System.out.println(rs.getString("ename"));
//        }
        System.out.println(pstm.getObject(1));

        //释放资源
        //rs.close();
        pstm.close();
        connection.close();
    }

}
