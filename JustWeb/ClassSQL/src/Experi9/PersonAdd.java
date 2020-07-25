package Experi9;

import Experi8.Database;
import Experi8.PersonSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.concurrent.ConcurrentNavigableMap;

public class PersonAdd extends JFrame{

    private JTextField userId,userName;
    private JRadioButton sexFemale,sexMale;
    private JPanel sex,birth;
    private JTextField year,dept;
    private JComboBox month,day,prof;
    private JButton ok,cancel;

    public PersonAdd(){
        super();
        this.setSize(350,300);
        this.setTitle("Login");
        this.setLocationRelativeTo(getOwner());//居中

        //设置组件布局
        Container cont = getContentPane();
        cont.setLayout(new GridLayout(7,2));

        //添加组件

        //用户名
        cont.add(new JLabel("员工号"));
        userId = new JTextField(10);
        cont.add(userId);

        //用户名
        cont.add(new JLabel("姓名"));
        userName = new JTextField(10);
        cont.add(userName);

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

        //出生日期
        cont.add(new JLabel("出生日期"));
        year = new JTextField(4);
        month = new JComboBox();

        int i;
        for(i=1;i<=12;i++){
            month.addItem(i);
        }

        day = new JComboBox();
        for(i=1;i<=31;i++){
            day.addItem(i);
        }

        birth = new JPanel();
        birth.add(year);
        birth.add(new JLabel("-"));
        birth.add(month);
        birth.add(new JLabel("-"));
        birth.add(day);
        cont.add(birth);

        //职称
        cont.add(new JLabel("职称"));
        prof = new JComboBox();
        prof.addItem("初级");
        prof.addItem("中级");
        prof.addItem("高级");
        cont.add(prof);

        //部门
        cont.add(new JLabel("部门"));
        dept = new JTextField(10);
        cont.add(dept);

        //按钮
        ok = new JButton("添加");
        cancel = new JButton("取消");
        cont.add(ok);
        cont.add(cancel);

        //注册监听器
        ok.addActionListener(new ActionListener() {
            //ok事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                Database database = new Database();

                try {
                    String sql = "insert into person values(?,?,?,?,?,?)";
                    PreparedStatement preStatement = database.preparedStatement(sql);
                    preStatement.setString(1,userId.getText());
                    preStatement.setString(2,userName.getText());
                    preStatement.setString(3,(sexMale.isSelected() ?
                            sexMale.getText():sexFemale.getText()));
                    preStatement.setString(4,year.getText()+"-"
                            +month.getSelectedItem()+"-"+day.getSelectedItem());
                    preStatement.setString(5,prof.getSelectedItem().toString());
                    preStatement.setString(6,dept.getText());

                    //执行
                    preStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Insert Successful!");
                    dispose();
                    PersonSelect perSelect = new PersonSelect();
                    perSelect.setVisible(true);

                } catch (Exception ex) {
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
        PersonAdd perAdd = new PersonAdd();
        perAdd.setVisible(true);
    }
}
