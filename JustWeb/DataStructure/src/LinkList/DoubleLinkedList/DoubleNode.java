package LinkList.DoubleLinkedList;

public class DoubleNode<T>{
    public T data;                //存数据
    public DoubleNode<T> prev,next;  //地址域  前驱 后继
    public DoubleNode(T data,DoubleNode<T> prev,DoubleNode<T> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoubleNode(){
        this(null,null,null);
    }

    public String toString(){
        return this.data.toString();
    }




}
