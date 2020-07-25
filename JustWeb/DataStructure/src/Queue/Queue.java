package Queue;

public interface Queue<T> {
    public abstract boolean isEmpty();   //队列判空

    public abstract boolean add(T x);    //元素x入队 添加成功则返回true 否则返回false

    public abstract T peek();  //返回队头元素 没有删除。若队列为空则返回null

    public abstract T poll();  //出队  返回队头元素 若队列为空 则返回null
}
