package LinkList.SinglyList;

public class SortedSinglyList<T extends Comparable<?super T>> extends SinglyList<T> {
    public SortedSinglyList(){
        super();
    }

    public SortedSinglyList(T[] value){
        super();
        for(int i=0;i<value.length;i++){
            this.insert(value[i]);
        }
    }

    public SortedSinglyList(SortedSinglyList<T> list){//深拷贝
        super(list);
    }

    public SortedSinglyList(SinglyList<T> list){//重载深拷贝 由单链表构造排序单链表
        super();
        for(Node<T> p = list.head.next; p!=null; p=p.next){
            this.insert(p.data);
        }
    }

    public void set(int i,T x){
        Node<T> p = this.head;
//        while (p.next!=null){
//            p = p.next;
//            if(p.data == get(i-1)){
//                p.next.data = (T)x;
//            }
//        }
//  上面的写法性能较低
        for(int j=0;j<i;j++){
            p = p.next;
        }
        p.next.data = (T)x;
    }
}
