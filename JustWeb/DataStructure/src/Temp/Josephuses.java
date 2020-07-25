package Temp;

import LinkList.SinglyList.SinglyList;

public class Josephuses {
    /*约瑟夫环（约瑟夫问题）是一个数学的应用问题：已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
    从编号为k的人开始报数，
    数到m的那个人出列；他的下一个人又从1开始报数，
    数到m的那个人又出列；依此规律重复下去，直到还剩最后一个人。
     */
    public Josephuses(int n,int k,int m){
        System.out.println("Total:"+n+",Index:"+k+",Out:"+m);
        SinglyList<String> list = new SinglyList<String>();
        char ch = 'A';
        for(int i=0;i<n;i++){
            list.insert(ch+"");
            ch += 1;
        }

        System.out.println(list);
        //n:总人数  k:序号  m:第几个人

        int i = k;
        while (list.size()>1){
            i = (i+m-1)%list.size();   //!!!!!!
            System.out.println("删除"+list.remove(i));
            System.out.println(list);
        }
        System.out.println("The Survivor is : "+list.get(0));

    }
    public static void main(String[] args) {
        new Josephuses(20,2,3);

    }
}
