package LinkList.TermX;

public interface Addible<T> {
    public void add(T t);      //+=加法  约定量元素相加规则
    public boolean removable();   //约定删除元素条件
}
