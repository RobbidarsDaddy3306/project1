package BinaryTree;

public class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    //构造二叉树
    public BinaryTree(T[] prelist){
        this.root = create(prelist);
    }
    private int i = 0;
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p =null;
        if(i<prelist.length){
            T elem = prelist[i];
            i++;
            if(elem!=null){
                p = new BinaryNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }

    public BinaryNode<T> insert(T x){  //插入x为根结点 原根结点作为x的左孩子
        return this.root = new BinaryNode<T>(x,this.root,null);
    }

    public BinaryNode<T> insert(BinaryNode<T> parent,T x,boolean leftChild){
        if(x == null){
            return null;
        }
        if(leftChild){
            return parent.left = new BinaryNode<T>(x,parent.left,null);
        }else {
            return parent.right = new BinaryNode<T>(x,null,parent.right);
        }
    }

    public void remove(BinaryNode<T>parent,boolean leftChild){
        if(leftChild){
            parent.left = null;
        }else {
            parent.right = null;
        }
    }

    public void clear(){
        this.root = null;
    }

    //遍历二叉树
    public void preorder(){   //先根遍历
        preorder(this.root);
        System.out.println();
    }
    private void preorder(BinaryNode<T> p){
        if(p!=null){
            System.out.println(p.data.toString());
            preorder(p.left);
            preorder(p.right);
        }
    }

    public String toString(){
        return toString(this.root);
    }
    private String toString(BinaryNode<T> p){
        if(p==null){
            return "^";
        }
        return p.data.toString()+" "+toString(p.left)+toString(p.right);
    }

    public void inorder(){   //中根遍历
        inorder(this.root);
        System.out.print(" ");
    }
    private void inorder(BinaryNode<T> p){
        if(p!=null){
            inorder(p.left);
            System.out.print(p.data.toString()+" ");
            inorder(p.right);
        }
    }

    public void postorder(){      //后根遍历
        postorder(this.root);
        System.out.print(" ");
    }
    private void postorder(BinaryNode<T> p){
        if(p!=null){
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");
        }
    }

    public int size(){  //返回节点数
        return size(this.root);
    }
    int count = 0;
    private int size(BinaryNode<T> p){
        if(p != null){
            count++;
            size(p.left);
            size(p.right);
        }
        return count;
    }

    public int height(){
        return height(this.root);
    }
    private int height(BinaryNode<T> p){
        if (p == null){
            return 0;
        }
        int lh = height(p.left);
        int rh = height(p.right);

        return (lh > rh)? lh+1 : rh+1;
    }



}
