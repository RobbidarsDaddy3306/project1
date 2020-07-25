package AutoChess;

import java.util.List;

public class Artillery extends Role{
    public Artillery() {
        name = "artillery";
    }

    @Override
    void action(Player p) {
        List<Role> list = p.list;
        for(int i=0;i<list.size();i++){
            Role target = list.get(i);
            target.HP -= 10;  //生命值减少10

            if(target.HP <= 0){
                list.remove(target);  //移除此个目标
                i--;  //让循环变量回退一位 ,防止因队列变短而导致的下标异常
            }
        }

    }
}
