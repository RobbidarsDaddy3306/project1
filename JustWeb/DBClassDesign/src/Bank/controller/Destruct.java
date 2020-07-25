package Bank.controller;

import Bank.util.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Destruct extends JFrame {
    private JLabel id,password;
    private JTextField iD;
    private JPasswordField passworD;
    private JButton ok,cancel;
    private Database database;

    public Destruct(String user){
        super();
        this.setSize(400,200);
        this.setTitle("销户");
        this.setLocationRelativeTo(getOwner());

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2));

        id = new JLabel("请输入账号");
        iD = new JTextField(10);

        password = new JLabel("请输入销户密码");
        passworD = new JPasswordField(10);

        ok = new JButton("确认");
        cancel = new JButton("取消");

        container.add(id);
        container.add(iD);
        container.add(password);
        container.add(passworD);
        container.add(ok);
        container.add(cancel);

        database = new Database();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String str2 = null;
                    String str = new String(passworD.getPassword());

                    String sql = "select * from delpwd where username = "+"'"+user+"'";
                    ResultSet rs = database.executeQuery(sql);

                    while (rs.next()){
                        str2   = rs.getString(3);
                    }
//                    System.out.println(userid);
//                    System.out.println(str2);
//                    System.out.println();
//                    System.out.println(str);

                    if(str.equals(str2)){
                        String sql1 = "delete from user where username = "+"'"+iD.getText()+"'";
                        System.out.println(sql1);
                        database.executeUpdate(sql1);

                        JOptionPane.showMessageDialog(null,"操作成功!");

                    }else {
                        JOptionPane.showMessageDialog(null,"密码错误操作失败!");
                    }

                    database.closeConnection();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Destruct("Admin").setVisible(true);
    }
}
