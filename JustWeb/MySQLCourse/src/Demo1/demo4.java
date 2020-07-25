package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo4 {
    @Test
    public void test() throws Exception{
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");

            String sql = "create table student(id int ,age int ,sex varchar(50))";

            statement = connection.createStatement();

            boolean execute = statement.execute(sql);
            System.out.println("execute = " + execute);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
