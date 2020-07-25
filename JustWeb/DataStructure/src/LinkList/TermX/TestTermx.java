package LinkList.TermX;

import LinkList.SinglyList.Node;
import org.junit.Test;

public class TestTermx {
//    @Test
//    public void test(){
//        System.out.println(new TermX(-1,5));
//    }
     public static void main(String[] args) {
        TermX[] aterms = {new TermX(-7,9),new TermX(2,7),new TermX(-9,4),
                new TermX(1,2),new TermX(-1,1),new TermX(5,6),
                new TermX(7,9),};
        PolySinglyList<TermX> list = new PolySinglyList<TermX>(aterms);
        System.out.println(list);
//         for(Node p=list.head.next;p!=null;p=p.next){
//             if(p.next == null){
//                 System.out.print(p.data);
//             }
//             System.out.print(p.data+"+");
//         }
     }
}
