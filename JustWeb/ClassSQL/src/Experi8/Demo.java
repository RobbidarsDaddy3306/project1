package Experi8;

import java.sql.*;

public class Demo {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123456";
        try {
            Database database = new Database();
            ResultSet rs = database.executeQuery("select * from user where Uname ="+"'"
                    +username+"'"+"and Upwd ="+"'"+password+"'");

            String uname = null;
            String upwd  = null;
            while (rs.next()){
                 uname = rs.getString(1);
                 upwd  = rs.getString(2);
            }


            System.out.println(uname);
            System.out.println(upwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
