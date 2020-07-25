package Bank.view;

import Bank.util.Database;
import Bank.pojo.Person;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssetQueryResult extends JFrame{
    //表格
    private JTable table;
    private MyTableModel tableModel;

    public AssetQueryResult(String indexQuery){
        this.setSize(800,500);
        this.setTitle("账户查询");
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
            ResultSet rs = dbconn.executeQuery("select * from user where username = "+"'"+indexQuery+"'");
            //获取查询结果的列名 填充表格模型
            ResultSetMetaData rsmd = rs.getMetaData();
            int Column = rsmd.getColumnCount();
            int i;

            for (i = 1; i<=Column; i++) {
                tableModel.addColumn(rsmd.getColumnName(i));
            }
            //获取查询结果中的元组 填充表格模型
            ArrayList<Person> personList = new ArrayList<Person>();

            while (rs.next()) {
                Person person = new Person();

                person.setNo(rs.getString("No"));
                person.setUserName(rs.getString("UserName"));
                person.setPassword(rs.getString("Password"));
                person.setSex(rs.getString("Sex"));
                person.setAddress(rs.getString("Address"));
                person.setBalance(rs.getDouble("Balance"));

                personList.add(person);
            }

            rs.close();

            for (i = 0; i < personList.size(); i++) {
                tableModel.addRow(new Object[]{personList.get(i).getNo(), personList.get(i).getUserName(), personList.get(i).getPassword()
                        , personList.get(i).getSex(), personList.get(i).getAddress(), personList.get(i).getBalance()});
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
        new AssetQueryResult("洛必达").setVisible(true);
    }
}
