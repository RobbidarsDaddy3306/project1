package LinkList.SinglyList;

public class SinglyList<T> extends Object{
    public Node<T> head; //头指针

    public SinglyList(){
        this.head = new Node<T>(); //头结点
    }
    public SinglyList(T[]values){
        this();
        Node<T> rear = this.head;
        for(int i=0;i<values.length;i++){
            rear.next = new Node<T>(values[i],null);
            rear = rear.next;
        }
    }
    public SinglyList(SinglyList<T> list){//深拷贝
        this();
        Node<T> p = list.head;
        Node<T> rear = this.head;
        while (p.next != null){
            p = p.next;

            rear.next = new Node<T>(p.data,null);

            rear = rear.next;

        }

    }
    public boolean isEmpty(){
        return this.head.next == null;
    }
    public T get(int i){
        Node<T> p = this.head.next;
        for(int j=0;p!=null && j<i;j++){
            p = p.next;
        }
        return (i>=0 && p!=null)? p.data:null;
    }

    public void set(int i,T x){
        Node<T> p = head;
        while (p != null){
            if(p.data == get(i-1)){
                p.next.data = (T)x;
            }
            p = p.next;
        }

    }
    public int size(){
        Node<T> p = head;
        int count = 0;
        while (true){
            p = p.next;
            if(p==null){
                break;
            }
            count++;
        }
        return count;
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

    public Node<T> insert(int i,T x){
        if(x==null){
            throw new NullPointerException();
        }
        Node<T> front = head;
        for(int j=0;front.next!=null && j<i;j++){
            front = front.next;
        }
        front.next = new Node<T>(x,front.next);
        return front.next;
    }
    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE,x);
    }

    public T remove(int i){
        Node<T> front = this.head;
        for(int j=0;front.next!=null && j<i;j++){
            front = front.next;
        }
        if(i>=0 && front.next!=null){
            T old = front.next.data;
            front.next = front.next.next;

            return old;
        }
        return  null;
    }

    public void clear(){
        this.head.next = null;
    }

    public Node<T> search(T key){//查找首个于key相等的元素
        Node<T> front = head;
        while (front.next!=null){
            front = front.next;
            if(front.data == key){
                return front;
            }else {
                return null;
            }
        }
        return null;
    }
    public boolean isContains(T key){
        Node<T> p = head;
        while (p.next!=null){
            p = p.next;
            if (p.data == key){
                return true;
            }
        }
        return false;
    }

    public Node<T> insertDifferent(T x){
        if(!isContains(x)){
            insert(x);
        }else {
            return null;
        }
        return null;
    }

    public T remove(T key){
        Node<T> p = head;
        int count = 0;
        while (p.next != null){
            p = p.next;
            count++;
            if(p.data == key){
                remove(count);
                return key;
            }
        }
        return null;
    }



}
