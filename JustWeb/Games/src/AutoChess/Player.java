package AutoChess;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Role> list = new ArrayList<Role>(); //己方队伍
    Player enemy;//敌方

    public Player() {
        list.add(new Medics());
        list.add(new Sniper());
        list.add(new Sniper());
        list.add(new Artillery());
        list.add(new Artillery());
    }

    public void setEnemy(Player enemy){  //设置敌人
        this.enemy = enemy;
    }

    void action(){   //操控者展开行动
        for(Role r : list){
            if(r instanceof Medics){
                r.action(this);
            }else{
                r.action(enemy);
            }
        }

    }


}
