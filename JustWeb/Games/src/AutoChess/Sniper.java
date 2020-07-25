package AutoChess;

import java.util.List;
import java.util.Random;

public class Sniper extends Role{
    public Sniper() {
        name = "sniper";
    }

    @Override
    void action(Player p) {
        List<Role> list = p.list;
        if(list.size() == 0){  //敌方没有士兵什么也不干
            return;
        }

        Random random = new Random();  //随机数
        Role target = list.get(random.nextInt(list.size()));  //随机获取一个敌人
        target.HP -= 30;   //生命值减少30

        if(target.HP <= 0){   //如果敌人死亡
            list.remove(target);   //移除此个目标
        }



    }
}
