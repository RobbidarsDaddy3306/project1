package Stack;

import LinearList.SeqList;

public final class SeqStack<T> implements Stack<T> {    //顺序栈
    private SeqList<T> list;           //使用顺序表

    public SeqStack(int length){ //构造容量为length的空栈
        this.list = new SeqList<T>(length);
    }

    public SeqStack(){    //构造默认容量的栈
        this(64);
    }

    public boolean isEmpty(){     //判空
        return this.list.isEmpty();
    }

    public void push(T x){     //元素x入栈
        this.list.insert(x);    //尾插入元素  自动扩容机制
    }

    public T peek(){
        return this.list.get(list.size()-1);    //返回栈顶元素
    }

    public T pop(){                         //出栈 返回栈顶元素  空栈返回null
        return list.remove(list.size()-1);
    }

}
