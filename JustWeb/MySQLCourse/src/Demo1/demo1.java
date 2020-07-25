package Demo1;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class demo1 {
    public static void main(String[] args) throws Exception{
        //1、导入驱动包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3、获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day04","root","root");
        //4、定义SQL语句
        String sql = "update account set salary = 800 where id = 1";
        //5、获取执行SQL语句的对象

        Statement statement = connection.createStatement();

        //6、执行SQL语句
        int count = statement.executeUpdate(sql);

        System.out.println("count = " + count);

        //关闭流
        statement.close();

        connection.close();


    }
}
