package Bank.pojo;

import Bank.view.MyTableModel;
import Bank.util.Database;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class Statistics extends JFrame {

    //表格
    private JTable table;
    private MyTableModel tableModel;

    public Statistics(String indexQuery){
        this.setSize(800,600);
        this.setTitle("历史操作记录查询");
        this.setLocationRelativeTo(getOwner());
        Container container = this.getContentPane();

        //获取表格模型
        tableModel = getModel(indexQuery);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,300));
        JScrollPane scroll = new JScrollPane(table);
        container.add(scroll,BorderLayout.CENTER);
    }



    private MyTableModel getModel(String indexQuery){
        MyTableModel tableModel = new MyTableModel();
        Database dbconn;

        try {
            dbconn = new Database();
            ResultSet rs = dbconn.executeQuery("select * from statistics where username = "+"'"+indexQuery+"'");
            //获取查询结果的列名 填充表格模型
            ResultSetMetaData rsmd = rs.getMetaData();
            int Column = rsmd.getColumnCount();
            int i;

            for (i = 1; i<=Column; i++) {
                tableModel.addColumn(rsmd.getColumnName(i));
            }
            //获取查询结果中的元组 填充表格模型
            ArrayList<History> historyList = new ArrayList<History>();

            while (rs.next()) {
                History history = new History();

                history.setNo(rs.getString("No"));
                history.setUserName(rs.getString("UserName"));
                history.setIncome(rs.getDouble("income"));
                history.setExpense(rs.getDouble("expense"));
                history.setBalance(rs.getDouble("balance"));
                history.setDate(rs.getDate("date"));
                history.setComment(rs.getString("Comment"));

                historyList.add(history);
            }

            rs.close();

            for (i = 0; i < historyList.size(); i++) {
                tableModel.addRow(new Object[]{historyList.get(i).getNo(), historyList.get(i).getUserName(), historyList.get(i).getIncome()
                        , historyList.get(i).getExpense(), historyList.get(i).getBalance(), historyList.get(i).getDate(),
                historyList.get(i).getComment()});
            }

            dbconn.closeConnection();
        }catch (SQLException sqle){
            System.out.println(sqle.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tableModel;
    }

    public static void main(String[] args) {
        new Statistics("洛必达").setVisible(true);
    }
}
