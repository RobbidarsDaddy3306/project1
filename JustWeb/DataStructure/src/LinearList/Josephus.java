package LinearList;

public class Josephus {
     public static void Josephus1(int number,int start,int distance){
         System.out.println("Josephus("+number+","+start+","+distance+"),");

         SeqList<String> seqList = new SeqList<String>(number);
         char ch = 'A';
         for(int i=0;i<number;i++){

             seqList.insert((char)ch+"");
             ch += 1;
         }
         System.out.println(seqList.toString());
         int i = start;
         while (seqList.size()>1){
             i = (i+distance-1) % seqList.size();
             System.out.print("删除"+seqList.remove(i).toString()+",");
             System.out.println(seqList.toString());
         }
         System.out.println("The Survivor is "+seqList.get(0).toString());
     }

    public static void main(String[] args) {
//         String[] values = {"A","B","C","D","E"};
//         SeqList<String> list = new SeqList<>(values);
//         System.out.println(list.toString());
        Josephus1(5,0,2);
    }
}
