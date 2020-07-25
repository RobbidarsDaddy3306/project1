package Experi7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentNavigableMap;

public class RegisterFrame extends JFrame{

    private JTextField username;
    private JPasswordField password,password2;
    private JRadioButton sexFemale,sexMale;
    private JPanel sex,birth,fav;
    private JTextField year;
    private JComboBox month,day;
    private JCheckBox f1,f2,f3;
    private JButton register,cancel;
    private JTextArea remmond;
    private JScrollPane scroll;

    public RegisterFrame(){
        super();
        this.setSize(450,400);
        this.setTitle("Register");
        this.setLocationRelativeTo(getOwner()); //居中

        //布局
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        //begin

        JPanel cont = new JPanel(new GridLayout(6,2));
        //用户名
        cont.add(new JLabel("用户名"));
        username = new JTextField(10);
        cont.add(username);

        //密码
        cont.add(new JLabel("密码"));
        password = new JPasswordField(10);
        cont.add(password);

        //密码校验
        cont.add(new JLabel("再输入一次密码"));
        password2 = new JPasswordField(10);
        cont.add(password2);

        //性别
        cont.add(new JLabel("性别"));
        sexMale = new JRadioButton("男",true);
        sexFemale = new JRadioButton("女");

        ButtonGroup bg = new ButtonGroup();
        bg.add(sexFemale);
        bg.add(sexMale);

        sex = new JPanel(new GridLayout(1,2));
        sex.add(sexMale);
        sex.add(sexFemale);

        cont.add(sex);

        //出生日期
        cont.add(new JLabel("出生日期"));
        year = new JTextField(4);
        month = new JComboBox();

        for(int i=1;i<=12;i++){
            month.addItem(i);
        }

        day = new JComboBox();
        for(int i=1;i<=31;i++){
            day.addItem(i);
        }

        birth = new JPanel();
        birth.add(year);
        birth.add(new JLabel("-"));
        birth.add(month);
        birth.add(new JLabel("-"));
        birth.add(day);
        cont.add(birth);

        //爱好
        cont.add(new JLabel("爱好"));
        f1 = new JCheckBox("运动");
        f2 = new JCheckBox("看电影");
        f3 = new JCheckBox("听音乐");

        fav = new JPanel();
        fav.add(f1);
        fav.add(f2);
        fav.add(f3);
        cont.add(fav);

        //简历
        JPanel cont1 = new JPanel(new GridLayout(1,2));
        cont1.add(new JLabel("简历"));
        remmond = new JTextArea(5,10);
        scroll = new JScrollPane(remmond);
        cont1.add(scroll);

        //按钮
        JPanel cont2 = new JPanel(new GridLayout(1,2));
        register = new JButton("注册");
        cancel = new JButton("注销");
        cont2.add(register);
        cont2.add(cancel);

        //加入到内容面板
        container.add(cont);
        container.add(cont1);
        container.add(cont2);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //register事件处理
                String pass = new String(password.getPassword());
                String pass2 = new String(password2.getPassword());

                if(pass2.equals(pass)){
                    //输入注册信息
                    String s;
                    s = "用户名"+username.getText()+"\n";
                    s += "密码:"+pass+"\n";
                    s += "性别:"+(sexMale.isSelected() ? sexMale.getText():sexFemale.getText())+"\n";
                    s += "出生日期:"+year.getText()+"-"+month.getSelectedItem()+"-"+day.getSelectedItem()+"\n";
                    s += "爱好:"+(f1.isSelected() ? f1.getText() :"")+(f2.isSelected() ? f2.getText() :"")+
                            (f3.isSelected() ? f3.getText() :"");
                    s += "简历:"+remmond.getText();
                    JOptionPane.showMessageDialog(null,s);
                }else {
                    JOptionPane.showMessageDialog(null,"密码不一致");
                }
            }
        });

        //end

    }


    public static void main(String[] args) {
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.setVisible(true);
    }
}
