package BinaryTree;

public class TestBinary {
    public static void main(String[] args) {
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> binaryTree = new BinaryTree<String>(prelist);
        System.out.println(binaryTree);//先根遍历

//        System.out.println("中根遍历");
//        binaryTree.inorder();

//        System.out.println("后根遍历");
//        binaryTree.postorder();



    }
}
