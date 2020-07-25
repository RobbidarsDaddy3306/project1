package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2 {
    /**
     * insert 插入数据
     * mysql驱动包5以后的版本中可以省略Class.forName();
     * 底层默认会帮我们加载此类的字节码文件对象。
     *
     */
    @Test
    public void test() throws SQLException {
        Connection connection = null;
        Statement stmt = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");
            //定义SQL语句
            String sql = "insert into account values(null,'Musk',20000)";
            //准备执行SQL语句的对象
            stmt = connection.createStatement();

            boolean execute = stmt.execute(sql);
            System.out.println("execute = " + execute);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(stmt != null){
                try{
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
