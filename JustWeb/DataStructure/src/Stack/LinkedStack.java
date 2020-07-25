package Stack;

import LinkList.SinglyList.SinglyList;

public final class LinkedStack<T> implements Stack<T> {  //链式栈
    private SinglyList<T> list;      //使用单链表存储栈元素

    public LinkedStack(){
        this.list = new SinglyList<T>();        //构造空单链表
    }

    public boolean isEmpty(){         //判空
        return this.list.isEmpty();
    }

    public void push(T x){          //元素x入栈  空对象不能入栈
        this.list.insert(0,x);        //头插入   每插入一个元素 都作为栈顶元素
    }

    public T peek(){               //返回栈顶元素
        return this.list.get(0);
    }

   public T pop(){
        return this.list.remove(0);
   }


}
