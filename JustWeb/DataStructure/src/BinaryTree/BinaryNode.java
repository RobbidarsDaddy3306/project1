package BinaryTree;

public class BinaryNode<T> {
    public T data;                      //数据域
    public BinaryNode<T> left,right;    //地址域
    //构造结点
    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data){
        this(data,null,null);
    }

    public String toString(){
        return this.data.toString();
    }

    public boolean isleaf(){
        return this.left == null && this.right == null;
    }
}
