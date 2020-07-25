package Queue;

public final class SeqQueue<T> implements Queue<T> {
    private Object element[];   //存储队列元素的数组

    private int front,rear;    //front rear 分别为队列头尾下表

    public SeqQueue(int length){   //构造容量为length的空队列
        if(length<64){
            length = 64;           //设置队列数组容量的最小值
        }
        this.element = new Object[length];
        this.front = this.rear = 0;
    }

    public SeqQueue(){        //默认构造方法
        this(64);
    }

    public boolean isEmpty(){        //队列判空
        return this.front == this.rear;
    }

    public boolean add(T x){
        if(x==null){
            return false;
        }
        if(this.front==(this.rear+1)%this.element.length){   //扩充机制
            Object[] temp = this.element;
            this.element = new Object[temp.length*2];
            int j = 0;
            for(int i=this.front; i!=this.rear; i=(i+1)%temp.length){
                this.element[j++] = temp[i];
            }
            this.front = 0;
            this.rear  = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1)%this.element.length;
        return true;
    }

    public T peek(){     //返回队头元素
        return this.isEmpty()?null:(T)this.element[this.front];
    }

    public T poll(){   //出队
        if(this.isEmpty()){
            return null;
        }
        T temp = (T)this.element[this.front];
        this.front = (this.front+1)%this.element.length;
        return temp;
    }
}
