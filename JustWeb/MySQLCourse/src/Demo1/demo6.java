package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class demo6 {
    @Test
    public void test() throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");
        Statement statement = connection.createStatement();

        String sql = "select * from account";

        try(connection;statement){
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int salary = rs.getInt(3);
                System.out.println("id,name,salary"+id+name+salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
