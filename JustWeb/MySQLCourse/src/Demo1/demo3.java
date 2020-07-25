package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo3 {

    @Test
    public void test() throws SQLException {
        Connection connection = null;
        Statement        stmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");

            stmt = connection.createStatement();

            String sql = "delete from account where id = 3";

            boolean execute = stmt.execute(sql);
            System.out.println("execute = " + execute);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
