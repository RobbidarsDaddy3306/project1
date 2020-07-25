package Bank.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StatisticsUtils {
    private Database database;


    public StatisticsUtils() {

    }

    public void insert(String userName, double income, double expense, double balance, Date date,String comment){
        database = new Database();
        try {
            String sql = "insert into statistics values(?,?,?,?,?,?,?)";
            String dateStr =  new SimpleDateFormat("yyyy-MM-dd").format(date);

            PreparedStatement preStatement = database.preparedStatement(sql);
            preStatement.setString(1,null);
            preStatement.setString(2,userName);
            preStatement.setDouble(3,income);
            preStatement.setDouble(4,expense);
            preStatement.setDouble(5,balance);
            preStatement.setString(6,dateStr);
            preStatement.setString(7,comment);

            preStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        String dateStr =  new SimpleDateFormat("yyyy-MM-dd").format(date);
        System.out.println(date);
        System.out.println(dateStr);
        new StatisticsUtils().insert("郭德纲",500,0,8000,date,"存款");
    }
}
