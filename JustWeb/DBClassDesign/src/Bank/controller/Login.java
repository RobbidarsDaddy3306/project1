package Bank.controller;

import Bank.main.Bank;
import Bank.util.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    private Database database;
    private JTextField userName;
    private JPasswordField password;
    private JButton  ok,register;
    private ImageIcon imageIcon;
    private Image img;
    public Login(){
        super();
        this.setSize(400,200);
        this.setTitle("Login");
        this.setLocationRelativeTo(getOwner());


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,3));

        //添加用户名 密码
        container.add(new JLabel("用户名"));
        userName = new JTextField(10);
        container.add(userName);

        container.add(new JLabel("密码"));
        password = new JPasswordField(10);
        container.add(password);


        imageIcon = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\login.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(235,60,Image.SCALE_DEFAULT));
        ok = new JButton(imageIcon);
        container.add(ok);

        imageIcon = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\registerButton.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(235,60,Image.SCALE_DEFAULT));
        register = new JButton(imageIcon);
        container.add(register);


        database = new Database();
        //监听器
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String str = new String(password.getPassword());
                    String sql = "select * from user where username = "+"'"+userName.getText()+"'";
                    System.out.println(sql);

                    String uname = null;
                    String upwd  = null;
                    ResultSet rs = database.executeQuery(sql);

                    while (rs.next()){
                        uname = rs.getString(2);
                        upwd  = rs.getString(3);
                    }
//                    System.out.println(uname);
//                    System.out.println(upwd);

                    if(userName.getText().equals(uname) && str.equals(upwd)){
                        new Bank(userName.getText()).setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"Access Denied");
                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
