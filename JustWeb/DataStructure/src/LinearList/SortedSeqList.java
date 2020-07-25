package LinearList;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    public SortedSeqList() {
        super();
    }
    public SortedSeqList(int length){
        super(length);
    }
    public SortedSeqList(T[] values){
        super(values.length);
        for (int i = 0; i < values.length; i++) {
            this.insert(values[i]);
        }
    }
    public int insert(T x){ //插入操作
        int i = 0;
        if(this.isEmpty() || x.compareTo(this.get(this.size()-1))>0){
            i = this.n;
        }else{
            while(i<this.n && x.compareTo(this.get(i))>0){
                i++;
            }
        }
        super.insert(i , x);
        return  i;
    }

    public void set (int i, T x){
        throw new UnsupportedOperationException("set(int i,T x)");
    }
    public int isnert(int i,T x){
        throw new UnsupportedOperationException("insert(int i,T x)");
    }
}
