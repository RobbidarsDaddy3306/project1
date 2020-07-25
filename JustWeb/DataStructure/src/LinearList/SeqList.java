package LinearList;

import java.util.Arrays;

public class SeqList<T> extends Object {
    protected Object[] element;
    protected int n;

    public SeqList(int length){
        this.element = new Object[length];

        this.n = 0;
    }

    public SeqList(){
        this(64);
    }

    public SeqList(T[] values){
        this(values.length);

        for(int i=0;i<values.length;i++){
            this.element[i] = values[i];
        }
        this.n = values.length;
    }
    //构建一个顺序表
    public SeqList(SeqList<?extends T>list){  //深拷贝
        this.n = list.n;
        this.element = new Object[list.element.length];
        for(int i=0;i<list.n;i++){
            this.element[i] = list.element[i];
        }
    }

    public boolean isEmpty(){
        return this.n==0;
    }

    public int size(){
        return this.n;
    }

    public T get(int i){
        if(i<0 || i>this.element.length){
            throw new NullPointerException();
        }else {
            return (T) this.element[i];
        }
    }

    public void set(int i,T x){
        if(x==null){
            throw  new NullPointerException();
        }
        if(i>=0 && i<this.n){
            this.element[i] = x;
        }else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String toString(){
        String str = this.getClass().getName()+"(";
        if(this.n>0){
            str += this.element[0].toString()+" ";
        }
        for(int i=1;i<size();i++){
            str += this.element[i].toString()+" ";
        }
        return str+")";
    }

    public int insert(int i, T x){
        if(x == null){
            throw new NullPointerException();
        }
        if(i<0){
            i = 0;
        }
        if(i>this.n){
            i = this.n;
        }
        Object[] source = this.element;
        if(this.n == element.length){
            this.element = new Object[source.length*2];
            for(int j=0;j<i;j++){
                this.element[j] = source[j];//复制数组前i-1个
            }
        }
        for(int j=this.n-1;j>=i;j--) {
            this.element[j + 1] = source[j];
        }
        this.element[i] = x;
        this.n++;//顺序表元素的个数

        return i;
    }

    public int insert(T x){
        return this.insert(this.n,x);
    }

    public T remove(int i){
        if(this.n>0 && i>=0 && i<this.n) {
            T old = (T) this.element[i];
            for(int j=i;j<this.n-1;j++){
                this.element[j] = this.element[j+1];
            }
            this.element[this.n-1] = null;
            this.n--;
            return  old;
        }
        return null;
    }
    public void clear(){
        this.n = 0;
    }

    public int search(T key){
        for(int i=0;i<this.n;i++) {
            if (key == element[i]) {
                return i;
            }
        }
        return -1;
    }

    public int insertDifferent(T x){
        for(int i=0;i<this.n;i++){
            if(x==element[i]){
                return -1;
            }
        }
        insert(this.n,x);
        return -1;
    }
    public T remove(T key){
        for(Object value : element){
            if(value.equals(key)){
                return (T)value;
            }else{
                return null;
            }
        }
        return null;
    }

    public boolean contains(T key){
        return this.search(key)!=-1;
    }

}
