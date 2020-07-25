package Experi8;

import Experi9.PersonAdd;
import Experi9.PersonQuery;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonSelect extends JFrame {
    //表格
    private JTable table;
    private MyTableModel tableModel;

    //按钮 工具
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JToolBar tool;

    //

    public PersonSelect(){
        this.setSize(800,600);
        this.setTitle("员工信息");
        this.setLocationRelativeTo(getOwner());  //居中

        //获取表格模型
        tableModel = getModel();
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500,200));
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll,BorderLayout.CENTER);

        b1 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\WRITER.GIF"));
        b1.setToolTipText("添加");
        b1.setFocusable(false);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);

        b2 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\UPDATE.png"));
        b2.setToolTipText("修改");
        b2.setFocusable(false);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);

        b3 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\DELETE.png"));
        b3.setToolTipText("删除");
        b3.setFocusable(false);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);

        b4 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\Search.png"));
        b4.setToolTipText("查询部门员工");
        b4.setFocusable(false);
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setVerticalTextPosition(SwingConstants.BOTTOM);

        //创建工具栏 添加按钮
        tool = new JToolBar();
        tool.add(b1);
        tool.add(b2);
        tool.add(b3);
        tool.add(b4);
        tool.setRollover(true);

        //添加工具栏
        getContentPane().add(tool,BorderLayout.NORTH);

        //监听器
        b1.addActionListener(new ActionListener() { //添加按钮
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonAdd perAdd = new PersonAdd();
                perAdd.setVisible(true);
                dispose();
            }
        });

        b2.addActionListener(new ActionListener() { //修改按钮
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = 0;
                int index = 0;
                int count = 0;
                Database database = new Database();
                if(table.getCellEditor()!=null){
                    table.getCellEditor().stopCellEditing();
                }

                try {
                    String sql = "update person set name=?,sex=?,birthday=?,professor=?,deptno=? where no=?";
                    PreparedStatement preStatement = database.preparedStatement(sql);
                    //获取 JTable 的所修改的行数
                    count = tableModel.getEditedIndex().size();
                    //获取JTable中所修改的行的数据 更新数据库
                    if(count>0) {
                        for (i = 0; i < count; i++) {
                            index = tableModel.getEditedIndex().get(i);

                            preStatement.setString(1, table.getValueAt(index, 1).toString());
                            preStatement.setString(2, table.getValueAt(index, 2).toString());
                            preStatement.setString(3, table.getValueAt(index, 3).toString());
                            preStatement.setString(4, table.getValueAt(index, 4).toString());
                            preStatement.setString(5, table.getValueAt(index, 5).toString());
                            preStatement.setString(6, table.getValueAt(index, 0).toString());

                            preStatement.addBatch();
                        }
                    }

                    preStatement.executeBatch();

                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database database = new Database();

                try {
                    if(table.getSelectedRows().length>0){
                        //获取JTable中选取的行
                        int[] selRowIndexes = table.getSelectedRows();
                        PreparedStatement preStatement = database.preparedStatement("delete from person where no=?");
                        for(int i=0;i<selRowIndexes.length;i++){
                            preStatement.setString(1,table.getValueAt(selRowIndexes[i],0).toString());
                            preStatement.addBatch();
                        }
                        //删除数据库中相应记录
                        preStatement.executeBatch();
                        //重新加载数据到JTable
                        tableModel = getModel();
                        table.setModel(tableModel);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonQuery personQuery = new PersonQuery();
                personQuery.personQuery2();
                personQuery.setVisible(true);
                dispose();
            }
        });


    }

    private MyTableModel getModel(){
        MyTableModel tableModel = new MyTableModel();
        Database dbconn;

        try {
            dbconn = new Database();
            ResultSet rs = dbconn.executeQuery("select * from person");
            //获取查询结果的列名 填充表格模型
            ResultSetMetaData rsmd = rs.getMetaData();
            int Column = rsmd.getColumnCount();
            int i;

            for (i = 1; i<=Column; i++) {
                tableModel.addColumn(rsmd.getColumnName(i));
            }
            //获取查询结果中的元组 填充表格模型
            ArrayList<PersonEntity> personList = new ArrayList<PersonEntity>();

            while (rs.next()) {
                PersonEntity person = new PersonEntity();

                person.setNo(rs.getString("No"));
                person.setName(rs.getString("Name"));
                person.setSex(rs.getString("Sex"));
                person.setBirthday(rs.getDate("Birthday"));
                person.setProfessor(rs.getString("Professor"));
                person.setDeptNo(rs.getString("DeptNo"));
                personList.add(person);
            }

            rs.close();

            for (i = 0; i < personList.size(); i++) {
                tableModel.addRow(new Object[]{personList.get(i).getNo(), personList.get(i).getName(), personList.get(i).getSex()
                        , personList.get(i).getBirthday(), personList.get(i).getProfessor(), personList.get(i).getDeptNo()});
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
        PersonSelect personSelect = new PersonSelect();
        personSelect.setVisible(true);
    }
}
