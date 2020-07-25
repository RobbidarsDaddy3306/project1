package Bank.controller;

import Bank.util.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register extends JFrame{

    private JTextField userName,address;
    private JPasswordField password,password2;
    private JRadioButton sexFemale,sexMale;
    private JPanel sex;
    private JButton ok,cancel;
    private ImageIcon imageIcon;

    public Register(){
        super();
        this.setSize(500,400);
        this.setTitle("开户");
        this.setLocationRelativeTo(getOwner());//居中

        //设置组件布局
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(6,2));

        //用户名
        cont.add(new JLabel("账号"));
        userName = new JTextField(10);
        cont.add(userName);

        //密码
        cont.add(new JLabel("密码"));
        password = new JPasswordField(10);
        cont.add(password);
        //密码校验
        cont.add(new JLabel("验证密码"));
        password2 = new JPasswordField(10);
        cont.add(password2);
        //性别
        cont.add(new JLabel("性别"));
        sexMale = new JRadioButton("男",true);
        sexFemale = new JRadioButton("女");
        ButtonGroup bg = new ButtonGroup();
        bg.add(sexMale);
        bg.add(sexFemale);
        sex = new JPanel(new GridLayout(1,2));
        sex.add(sexMale);
        sex.add(sexFemale);
        cont.add(sex);

        //地址
        cont.add(new JLabel("住址"));
        address = new JTextField(10);
        cont.add(address);

        //按钮
        imageIcon = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\confirm.jpg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(235,60,Image.SCALE_DEFAULT));
        ok = new JButton(imageIcon);

        imageIcon = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\cancel.png.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(235,60,Image.SCALE_DEFAULT));
        cancel = new JButton(imageIcon);
        cont.add(ok);
        cont.add(cancel);

        //注册监听器
        ok.addActionListener(new ActionListener() {
            //ok事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Database database = new Database();
                    String pass = new String(password.getPassword());
                    String pass2 = new String(password2.getPassword());
                    String sql0  = "select * from user where username = "+"'"+userName.getText()+"'";
                    System.out.println(sql0);
                    ResultSet rs = database.executeQuery(sql0);
                    String uname = null;
                    while (rs.next()){
                        uname = rs.getString("UserName");
                    }

                    if(!userName.getText().equals(uname)){
                        if(pass2.equals(pass)){
                            String sql = "insert into user values(?,?,?,?,?,?)";
                            PreparedStatement preStatement = database.preparedStatement(sql);
                            preStatement.setString(1,null);
                            preStatement.setString(2,userName.getText());
                            preStatement.setString(3,pass);
                            preStatement.setString(4,sexMale.isSelected()?sexMale.getText():sexFemale
                                    .getText());
                            preStatement.setString(5,address.getText());
                            preStatement.setString(6,"0");
                            //执行
                            preStatement.executeUpdate();

                            JOptionPane.showMessageDialog(null,"Insert Successful!");
                            dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,"密码不一致");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"此用户名已存在!");
                    }
                    database.closeConnection();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //取消监听器
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame();
            }
        });
    }

    private void closeFrame(){

        int result = JOptionPane.showConfirmDialog(null,
                "是否要退出？", "退出确认", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION)
            this.dispose();
    }

    public static void main(String[] args) {
        new Register().setVisible(true);
    }
}
