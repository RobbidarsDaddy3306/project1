package Demo1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class demo8 {
    /*1.通过键盘录入用户名和密码的方式，
 *  到数据库中判断
 *      1.当前用户不存在 返回“用户名不存在”
 *      2.如果用户名存在，但是密码错误，返回“密码错误，请重新输入”
 *      3.如果用户名和密码输入正确，返回“登陆成功”
 *
 *
 *      这就是sql注入。
     */
    public static void main(String[] args) throws Exception{

        Connection connection = DriverManager.getConnection("jdbc:mysql:///day04","root","root");
        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next();

        System.out.println("请输入密码");
        String password = "12sdfsdf' or '1'='1";

        String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
        System.out.println("sql = "+sql);

        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            System.out.println("Successfully Logged in");
        }else {
            System.out.println("Access Denied");
        }



    }
}
