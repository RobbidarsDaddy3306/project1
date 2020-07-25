package Bank.util;

import java.sql.*;

public class Database {
    private Connection connection;
    private Statement  statement;

    public Database(){
       String driverName = "com.mysql.jdbc.Driver";
       String dbURL = "jdbc:mysql://localhost:3306/classdesign";
       String userName = "root";  //默认用户名
       String userPassword = "root"; //密码

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(dbURL,userName,userPassword);
            //如果连接成功 则在控制台输出Connection Successful
            System.out.println("Connection Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //数据更新操作
    public int executeUpdate(String sql) throws SQLException{
        statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }
    //数据查询操作
    public ResultSet executeQuery(String sql) throws SQLException{
        statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    //预处理对象
    public PreparedStatement preparedStatement(String sql) throws  SQLException{
        return connection.prepareStatement(sql);
    }

    //关闭流
    public void closeConnection() throws SQLException{
        statement.close();
        connection.close();
    }

}
