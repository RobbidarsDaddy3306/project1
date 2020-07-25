package Experi7;

import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame {
    //菜单栏
    private JMenuBar menuBar;//导航条
    private JMenu menu1;//下拉菜单
    private JMenuItem m11;//选项
    private JMenuItem m12;
    private JMenu menu2;//下拉菜单
    private JMenuItem m21;
    private JMenuItem m22;
    private JMenuItem m23;
    private JMenuItem m24;


    //按钮
    private JButton b1;
    private JButton b2;
    private JToolBar tool;
    //



    public HelloWorld(){
        super();
        this.setSize(400,300);
        this.setTitle("HelloWorld");
        this.setLocationRelativeTo(getOwner()); //居中
        //begin

        //菜单栏
        menu1 = new JMenu("系统");
        m11 = new JMenuItem("用户管理");
        m12 = new JMenuItem("退出");
        menu1.add(m11);
        menu1.add(m12);

        //创建数据操作菜单
        menu2 = new JMenu("数据操作");
        m21 = new JMenuItem("查询");
        m22 = new JMenuItem("添加");
        m23 = new JMenuItem("修改");
        m24 = new JMenuItem("删除");
        menu2.add(m21);
        menu2.add(m22);
        menu2.add(m23);
        menu2.add(m24);


        //创建菜单栏 添加系统菜单 数据操作菜单
        menuBar = new JMenuBar();
        menuBar.add(menu1);
        menuBar.add(menu2);

        //添加菜单栏到窗口
        setJMenuBar(menuBar);

        //按钮部分
        b1 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\UPWATER.GIF"));
        b1.setToolTipText("查询");
        b1.setFocusable(false);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);

        b2 = new JButton(new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\ClassSQL\\src\\icons\\WRITER.GIF"));
        b2.setToolTipText("添加");
        b2.setFocusable(false);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);

        //创建工具栏 添加按钮
        tool = new JToolBar();
        tool.add(b1);
        tool.add(b2);
        tool.setRollover(true);
        //添加工具栏
        getContentPane().add(tool, BorderLayout.PAGE_START);
        //end
    }

    public static void main(String[] args) {
            HelloWorld hw = new HelloWorld();
            hw.setVisible(true);

    }



}
