package AutoChess;

import java.util.List;
import java.util.Random;

public class Medics extends Role{
    public Medics() {
         name = "medics";
    }

    @Override
    void action(Player p) {
        List<Role> list = p.list;   //获取友军的队列

        if(list.size() == 0){  //如果友军队列数量为0 则什么也不做
            return;
        }

        Random random = new Random();  //随机数
        Role target = list.get(random.nextInt(list.size()));   //随机获取一个友军的士兵
        target.HP += 20;  //血量增加20点




    }
}
