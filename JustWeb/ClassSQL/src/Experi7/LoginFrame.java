package Experi7;


import Experi8.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {
    private Database database;
    private JTextField username;
    private JPasswordField password;
    private JButton login,register;

    public LoginFrame(){
        super();
        this.setSize(300,200);
        this.setTitle("Login");
        this.setLocationRelativeTo(getOwner());

        //begin
        //设置一个3行2列的表格
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(3,2));

        //添加用户名 和 密码
        cont.add(new JLabel("username"));
        username = new JTextField(10);
        cont.add(username);

        cont.add(new JLabel("password"));
        password = new JPasswordField(10);
        cont.add(password);

        //添加 登录 和 注册 按钮
        login = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\4.png"));
        register = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\3.png"));

        cont.add(login);
        cont.add(register);

        //连接数据库
        database = new Database();

        //登录监听器
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String str = new String(password.getPassword());
                    ResultSet rs = database.executeQuery("select * from user where Uname ="+"'"
                            +username.getText()+"'"+" and Upwd ="+"'"+str+"'");

//                    String sql = "select * from user where Uname ="+"'"
//                            +username.getText()+"'"+" and Upwd ="+"'"+new String(password.getPassword()+"'");
                    String uname = null;
                    String upwd  = null;

                    while (rs.next()){
                        uname = rs.getString(1);
                        upwd  = rs.getString(2);
                    }

//                    System.out.println(uname);
//                    System.out.println(upwd);
//                    System.out.println(username.getText());
//                    System.out.println(new String(password.getPassword()));
//                    System.out.println(str);
//                    System.out.println(sql);
                    //login事件处理
                    String pass = new String(password.getPassword());

                    if(username.getText().equals(uname) && pass.equals(upwd)){
                        HelloWorld helloWorld = new HelloWorld();
                        helloWorld.setVisible(true);
                        dispose();
                    }else {
                        JOptionPane.showMessageDialog(null,"Access Denied");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //end

    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
