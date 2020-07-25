package AutoChess;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        Player player = new Player();
        Player robot  = new Player();

        player.setEnemy(robot);   //互相设置敌人
        robot.setEnemy(player);

        List<Role> list1 = player.list;  //获取己方的士兵队列
        List<Role> list2 = robot.list;  //获取敌方的士兵队列

        //设置后手优势
        list2.add(new Medics()); //为后手方补偿一个医疗兵

//        System.out.println(list1.get(2).name + " "+list1.get(2).HP);
//        System.out.println(list2.get(2).name + " "+list2.get(2).HP);

        while (true){
            int count = list1.size()>list2.size() ? list1.size():list2.size();

            for(int i=0; i<count ;i++){
                //显示我方的状态
                if(i<list1.size()){
                    System.out.print(list1.get(i).name + "(HP=" + list1.get(i).HP +")");
                }else {
                    System.out.print("\t          ");
                }

                System.out.print("\t          ");

                //显示敌方的状态
                if(i<list2.size()){
                    System.out.print(list2.get(i).name + "(HP=" +list2.get(i).HP +")");
                }
                System.out.println();  //显示完对方的状态就换行
            }
            System.out.println("----------------------------------------------------");

            player.action();
            robot.action();

            if(list1.size() == 0){
                System.out.println("AI wins");
                break;
            }

            if(list2.size() == 0){
                System.out.println("player wins");
                break;
            }

            try {
                Thread.sleep(3000);   //设置执行间隔3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
