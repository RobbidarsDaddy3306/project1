package BinaryTree.Huffman;

public class TriElement {   //二叉树的静态三叉链表结点类
    int data;         //数据
    int parent,left,right;     //父母结点 和 左右孩子结点下标

    //构造节点
    public TriElement(int data,int parent,int left,int right){
        this.data   = data;
        this.parent = parent;
        this.left   = left;
        this.right  = right;
    }
    //构造数据为data 无父母的叶子结点
    public TriElement(int data){
        this(data,-1,-1,-1);
    }

    @Override
    public String toString(){
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }

    //判断是否是叶子结点  叶子结点 没有孩子的结点
    public boolean isLeaf(){
        return this.left==-1 && this.right==-1;
    }

}
