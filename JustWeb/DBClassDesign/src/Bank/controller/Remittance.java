package Bank.controller;

import Bank.util.Database;
import Bank.util.StatisticsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Remittance extends JFrame {
    private JLabel amout,id;
    private JTextField amout1,iD;
    private JButton ok,cancel;
    private Database database;
    private StatisticsUtils utils;

    public Remittance(String user){
        super();
        this.setSize(400,200);
        this.setTitle("Remittance");
        this.setLocationRelativeTo(getOwner());

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,4));

        id = new JLabel("请输入对方的账号");
        iD = new JTextField(10);

        amout = new JLabel("请输入金额");
        amout1 = new JTextField(10);

        ok = new JButton("确认");
        cancel = new JButton("取消");

        container.add(id);
        container.add(iD);
        container.add(amout);
        container.add(amout1);
        container.add(ok);
        container.add(cancel);


        database = new Database();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "select balance from user where username = "+"'"+user+"'";
                    ResultSet rs = database.executeQuery(sql);
                    double bal = 0;

                    while (rs.next()){
                        bal = rs.getDouble(1);

                    }
                    System.out.println(bal);

                    String sql0 = "select * from user where username = "+"'"+iD.getText()+"'";
                    System.out.println(sql0);
                    String userName = null;
                    double bal1 = 0;
                    ResultSet rs1 = database.executeQuery(sql0);
                    while (rs1.next()){
                        userName = rs1.getString("UserName");
                        bal1     = rs1.getDouble("Balance");
                    }
                    System.out.println(userName);

                    double deal = Double.parseDouble(amout1.getText());

                    String sql1 = "update user set balance = balance - " + amout1.getText() +
                            " where username = " + "'" + user + "'";
                    String sql2 = "update user set balance = balance + " + amout1.getText() +
                            " where username = " + "'" + iD.getText() + "'";

                    utils = new StatisticsUtils();

                    if(userName != null){
                        if(bal>deal){
//                        System.out.println(sql1);
//                        System.out.println(sql2);

                            database.executeUpdate(sql1);
                            database.executeUpdate(sql2);
                            utils.insert(user,0,deal,bal-deal,new Date(),"转账给: "+iD.getText());
                            utils.insert(iD.getText(),deal,0,bal1+deal,new Date(),"转账自: "+user);

                            JOptionPane.showMessageDialog(null, "交易成功!");
                        }else {
                            JOptionPane.showMessageDialog(null,"余额不足交易失败!");

                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"该用户不存在!");
                    }

                    database.closeConnection();

                } catch (SQLException ex) {
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
        new Remittance("洛必达").setVisible(true);
    }
}
