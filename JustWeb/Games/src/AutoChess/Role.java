package AutoChess;

public abstract class Role {
    int HP = 100;  //生命值
    String name; //兵种名称

    abstract void action(Player p);
}
