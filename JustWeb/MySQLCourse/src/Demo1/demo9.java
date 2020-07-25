package Demo1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class demo9 {
    @Test
    public void test(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from emp";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Object object = resultSet.getObject(1);
                Object oject2 = resultSet.getObject(2);
                System.out.println(object+","+oject2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,statement,connection);
        }
    }
}
class JDBCUtils{
    private static String url;
    private  static String username;
    private  static String password;
    private  static String driver;

    static {
        try {
            Properties properties = new Properties();
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("properties.properties");
            properties.load(in);
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(ResultSet rs,Statement statement,Connection connection){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}