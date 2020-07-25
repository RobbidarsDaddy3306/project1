package Bank.controller;

import Bank.util.Database;
import Bank.util.StatisticsUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deal extends JFrame {
    private JButton deposit;
    private JButton withdraw;
    private JButton back;


    public Deal(String user){
        super();
        this.setSize(400,100);
        this.setTitle("Deposit & Withdraw");
        this.setLocationRelativeTo(getOwner());

        deposit  = new JButton("存款");
        withdraw = new JButton("取款");
        back     = new JButton("取消");

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,3));
        container.add(deposit);
        container.add(withdraw);
        container.add(back);

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deposit(user).setVisible(true);
            }
        });

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Withdraw(user).setVisible(true);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Deal("洛必达").setVisible(true);
    }
}

class Deposit extends JFrame{
    private JLabel amout;
    private JTextField amout1;
    private JButton ok,cancel;
    private Database database;
    private StatisticsUtils utils;
    public Deposit(String user){
        super();
        this.setSize(300,150);
        this.setTitle("Deposit");
        this.setLocationRelativeTo(getOwner());

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,2));

        amout = new JLabel("请输入金额");
        amout1 = new JTextField(10);
        ok    = new JButton("确定");
        cancel = new JButton("取消");

        container.add(amout);
        container.add(amout1);
        container.add(ok);
        container.add(cancel);

        database = new Database();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "update user set balance = balance + "+amout1.getText()+
                            " where username = "+"'"+user+"'";
                    System.out.println(sql);

                    String sql1 = "select * from user where username = "+"'"+user+"'";
                    double bal = 0;
                    double deal = Double.parseDouble(amout1.getText());
                    ResultSet rs = database.executeQuery(sql1);
                    while (rs.next()){
                        bal = rs.getDouble(6);
                    }

                    database.executeUpdate(sql);

                    utils = new StatisticsUtils();
                    utils.insert(user,deal,0,bal+deal,new Date(),"存款");

                    JOptionPane.showMessageDialog(null,"交易成功");

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
        new Deposit("洛必达").setVisible(true);
    }
}


class Withdraw extends JFrame{
    private JLabel amout;
    private JTextField amout2;
    private JButton ok,cancel;
    private Database database;
    private StatisticsUtils utils;

    public Withdraw(String user){
        super();
        this.setSize(300,150);
        this.setTitle("Withdraw");
        this.setLocationRelativeTo(getOwner());

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,2));

        amout = new JLabel("请输入金额");
        amout2 = new JTextField(10);
        ok    = new JButton("确定");
        cancel = new JButton("取消");

        container.add(amout);
        container.add(amout2);
        container.add(ok);
        container.add(cancel);

        database = new Database();

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String sql = "update user set balance = balance - "+amout2.getText()+
                            " where username = "+"'"+user+"'";
                    System.out.println(sql);
                    String sql1 = "select * from user where username = "+"'"+user+"'";
                    System.out.println(sql1);
                    ResultSet rs = database.executeQuery(sql1);
                    double bal = 0;
                    double deal = Double.parseDouble(amout2.getText());
                    while(rs.next()){
                        bal = rs.getDouble(6);
                    }
                    if(bal>deal){  //余额大于交易额
                        database.executeUpdate(sql);

                        JOptionPane.showMessageDialog(null,"交易成功");

                        utils = new StatisticsUtils();
                        utils.insert(user,0,deal,bal-deal,new Date(),"取款");

                    }else {
                        JOptionPane.showMessageDialog(null,"余额不足交易失败");
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
        new Withdraw("洛必达").setVisible(true);
    }
}