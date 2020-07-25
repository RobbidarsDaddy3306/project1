package BinaryTree.Huffman;

public class HuffmanTree { //Huffman树类

    private String charsert;      //字符集合  要压缩的字符长串

    private TriElement[] huftree;    //静态三叉链表结点数组

    //构造Huffman树  wieghts指定权值集合  数组长度指定叶子结点数  默认字符集合从A开始

    public HuffmanTree(int[] weights){
        this.charsert = "";
        for(int i=0;i<weights.length;i++){
            this.charsert += (char)('A'+i);      //默认字符集合是从A开始
        }

        int n = weights.length;        //数组长度指定叶子结点数
        this.huftree = new TriElement[2*n-1];   //n个叶子结点 的二叉树有2n-1个结点
        for (int i = 0; i < n; i++) {
            this.huftree[i] = new TriElement(weights[i]);
        }
        for(int i=n;i<2*n-1;i++){  //构造n-1个2度结点
            int min1 = Integer.MAX_VALUE;  //最小和次小权值 初值为最大整数
            int min2 = min1;

            int x1 = -1,x2 = -1;  //最小和次小权值结点下标
            for(int j=0;j<i;j++){  //寻找两个无父母的最小权值结点的下标
                if(this.huftree[j].parent==-1){  //第j个结点无父母
                    if(this.huftree[j].data<min1){  //第j个结点权值最小
                        min2 = min1;
                        x2 = x1;           //x2记得次小权值结点下标
                        min1 = this.huftree[j].data;   //min1记得最小权值
                        x1 = j;
                    }else if(this.huftree[j].data<min2){
                        min2 = huftree[j].data;
                        x2 = j;
                    }
                }
            }
            this.huftree[x1].parent = i;   //合并两棵权值最小的子树 左孩子最小
            this.huftree[x2].parent = i;
            this.huftree[i] = new TriElement(min1+min2,-1,x1,x2); //构造结点
        }

    }

    private String getCode(int i){      //返回charset第i个字符的Huffman编码字符串
        int n = 8;
        char hufcode[] = new char[n];
        int child = i,parent = this.huftree[child].parent;
        for(i=n-1;parent!=-1;i--){
            hufcode[i] = (huftree[parent].left==child)?'0':'1';
            child = parent;
            parent = huftree[child].parent;
        }
        return new String(hufcode,i+1,n-1-i);
    }

    @Override
    public String toString() {
        String str = "Huffman Tree Node Array :";
        for(int i=0;i<this.huftree.length;i++){
            str += this.huftree[i].toString()+", ";
        }
        str += "\n HuffmanCode :  ";
        for(int i=0;i<this.charsert.length();i++){
            str += this.charsert.charAt(i)+": "+getCode(i)+", ";
        }
        return str;
    }

    //数据压缩
    public String encode(String text){
        String compressed = "";
        for(int i=0;i<text.length();i++){  //被压缩的数据 以字符串显示
            compressed += getCode(text.charAt(i)-'A');
        }
        return compressed;
    }

    //数据解压
    public String decode(String compressed){
        String text = "";
        int node = this.huftree.length-1;
        for(int i=0;i<compressed.length();i++){

            if(compressed.charAt(i) == '0'){
                node = huftree[node].left;
            }else {
                node = huftree[node].right;
            }
            if(huftree[node].isLeaf()){
                text += this.charsert.charAt(node);
                node = this.huftree.length-1;
            }
        }
        return text;
    }
}
