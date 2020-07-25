package Experi9;

import Experi8.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PersonQuery extends JFrame {

    public JTextField perQuery;
    private JButton   ok,cancel;

    public void personQuery2(){
        this.setSize(400,150);
        this.setTitle("员工部门查询");
        this.setLocationRelativeTo(getOwner());

        Container container = getContentPane();
        container.setLayout(new GridLayout(2,2));

        container.add(new JLabel("请输入要查询的部门(部门代号)"));
        perQuery = new JTextField(10);
        container.add(perQuery);

        ok = new JButton("确定");
        cancel = new JButton("取消");
        container.add(ok);
        container.add(cancel);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    PersonResult rs = new PersonResult(perQuery.getText());
                    rs.setVisible(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


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
        PersonQuery personQuery = new PersonQuery();
        personQuery.personQuery2();
        personQuery.setVisible(true);
    }
}
