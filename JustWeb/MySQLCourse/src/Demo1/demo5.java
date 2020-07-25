package Demo1;

import org.junit.Test;

import java.sql.*;

public class demo5 {
    @Test
    public void test() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");
        Statement statement = connection.createStatement();

        String sql = "select * from account";

        try(connection;statement){
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int salary = rs.getInt(3);
                System.out.println("id+\",\"+name+\",\"+salary = " + id+","+name+","+salary);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
