package Experi9;

import Experi8.Database;
import Experi8.MyTableModel;
import Experi8.PersonEntity;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class PersonResult extends JFrame {
    //表格
    private JTable table;
    private MyTableModel tableModel;

    public PersonResult(String perquery){
        this.setSize(800,600);
        this.setTitle("员工部门信息表");
        this.setLocationRelativeTo(getOwner());

        //获取表格模型

//        String str = pq.perQuery.getText();
//        String sql = "select * from person where deptno = "+"'"+str+"'";
        tableModel = getModel(perquery);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,200));
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll,BorderLayout.CENTER);

    }

    private MyTableModel getModel(String perquery){
        MyTableModel tableModel = new MyTableModel();
        Database database;

        try {
            System.out.println(perquery);
            database = new Database();
            String sql = "select * from person where deptno ="+"\'"+perquery+"\'";
            ResultSet rs = database.executeQuery(sql);
            //获取查询结果的列名 填充表格模型
            ResultSetMetaData rsmd = rs.getMetaData();
            int Column = rsmd.getColumnCount();

            tableModel.addColumn("No");
            tableModel.addColumn("Name");
            tableModel.addColumn("DeptNo");
            //获取查询结果中的元组 填充表格模型
            ArrayList<PersonEntity> personDeptNo = new ArrayList<PersonEntity>();

            while (rs.next()){
                PersonEntity person = new PersonEntity();

                person.setNo(rs.getString(1));
                person.setName(rs.getString(2));
                person.setDeptNo(rs.getString(6));
                personDeptNo.add(person);
            }

            rs.close();

            for(int i=0;i<personDeptNo.size();i++){
                tableModel.addRow(new Object[]{personDeptNo.get(i).getNo(),personDeptNo.get(i).getName(),
                personDeptNo.get(i).getDeptNo()});
            }
            database.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tableModel;
    }

    public static void main(String[] args) {
        new PersonResult("00103").setVisible(true);

    }
}
