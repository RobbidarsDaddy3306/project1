package LinkList.TermX;

import LinkList.SinglyList.Node;
import LinkList.SinglyList.SortedSinglyList;

public class PolySinglyList<T extends Comparable<?super T> & Addible<T>> extends SortedSinglyList<T> {
    //多项式排序单链表
    public PolySinglyList(){    //构造方法
        super();
    }

    public PolySinglyList(T terms[]){   //由数组指定多项式各项的值
        this();
        Node<T> front = this.head;
        for(int i=0;i<terms.length;i++){
            front.next = new Node<T>(terms[i],null);
            front = front.next;
        }
    }

    public String toString(){
        String str = this.getClass().getName()+"(";
        for(Node<T>p=this.head.next; p!=null; p=p.next){
            str += p.data.toString();
            if(p.next!=null){
                str += ",";
            }
        }
        return str+")";
    }
}
