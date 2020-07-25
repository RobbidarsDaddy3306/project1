package Bank.main;

import Bank.controller.Deal;
import Bank.controller.Destruct;
import Bank.controller.Register;
import Bank.controller.Remittance;
import Bank.pojo.Statistics;
import Bank.view.AssetQueryResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Bank extends JFrame {
    //按钮
    private JButton b1;  //储蓄卡开户
    private JButton b2;  //存取款业务
    private JButton b3;  //汇款转账 业务
    private JButton b4;  //查询业务
    private JButton b5;  //卡注销
    private JButton b6;  //统计报表功能
    private JButton b7;  //系统安全管理
    private JToolBar tool;
    private ImageIcon image;
    private Image img;
    public  int width = 100;
    public  int height = 100;

    public Bank(String user) {
        super();
        Container container = this.getContentPane();  //容器
        this.setSize(820,800);
        this.setTitle("Credit Card Management System // Welcome "+user);
        this.setLocationRelativeTo(getOwner());


        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\register.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b1 = new JButton(image);
        b1.setToolTipText("储蓄卡开户");
        b1.setFocusable(false);
        b1.setHorizontalTextPosition(SwingConstants.CENTER);
        b1.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\deposit.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b2 = new JButton(image);
        b2.setToolTipText("存取款业务");
        b2.setFocusable(false);
        b2.setHorizontalTextPosition(SwingConstants.CENTER);
        b2.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\remittance.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b3 = new JButton(image);
        b3.setToolTipText("汇款转账业务");
        b3.setFocusable(false);
        b3.setHorizontalTextPosition(SwingConstants.CENTER);
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\Query.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b4 = new JButton(image);
        b4.setToolTipText("查询业务");
        b4.setFocusable(false);
        b4.setHorizontalTextPosition(SwingConstants.CENTER);
        b4.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\logout.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b5 = new JButton(image);
        b5.setToolTipText("卡注销");
        b5.setFocusable(false);
        b5.setHorizontalTextPosition(SwingConstants.CENTER);
        b5.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\statistics.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b6 = new JButton(image);
        b6.setToolTipText("统计报表功能");
        b6.setFocusable(false);
        b6.setHorizontalTextPosition(SwingConstants.CENTER);
        b6.setVerticalTextPosition(SwingConstants.BOTTOM);

        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\management.png");
        image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));
        b7 = new JButton(image);
        b7.setToolTipText("系统安全管理功能");
        b7.setFocusable(false);
        b7.setHorizontalTextPosition(SwingConstants.CENTER);
        b7.setVerticalTextPosition(SwingConstants.BOTTOM);
        b7.setEnabled(false);

        if(user.equals("Admin")){
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b6.setEnabled(false);
        }else {
            b1.setEnabled(false);
            b5.setEnabled(false);
        }

        tool = new JToolBar();
        tool.add(b1);
        tool.add(b2);
        tool.add(b3);
        tool.add(b4);
        tool.add(b5);
        tool.add(b6);
        tool.add(b7);
        tool.setRollover(true);

//        文本域
//        txt = new JTextArea("   尊敬的会员您好，             \n" +
//                "欢迎进入银行卡管理系统！\n" +
//                "                                 \n" +
//                "请按照提示完成您想要办理的业务。\n" +
//                "\n" +
//                "上面的业务图片功能依次为:\n" +
//                "\n" +
//                "1、银行卡开户\n" +
//                "2、存款或者取款\n" +
//                "3、转账汇款\n" +
//                "4、查询业务(银行卡余额、历史记录)\n" +
//                "5、银行卡注销\n" +
//                "6、统计报表业务\n" +
//                "7、系统设置功能");
//        Font font = new Font("楷体",Font.BOLD,20);
//        txt.setFont(font);
//        txt.setEditable(false);
        //大图片
        image = new ImageIcon("C:\\Users\\DELL\\IdeaProjects\\JustWeb\\DBClassDesign\\src\\images\\property.jpg");
        image.setImage(image.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT));
        img = image.getImage();

        //添加组件
        container.add(tool, BorderLayout.NORTH);
        container.add(new CanvasPanel());


        //监听器
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Deal(user).setVisible(true);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Remittance(user).setVisible(true);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AssetQueryResult(user).setVisible(true);
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Destruct(user).setVisible(true);
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Statistics(user).setVisible(true);
            }
        });
    }

    class CanvasPanel extends Canvas{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.drawImage(img,0,0,this);
        }
    }


    public static void main(String[] args) {
        new Bank("洛必达").setVisible(true);
    }
}
