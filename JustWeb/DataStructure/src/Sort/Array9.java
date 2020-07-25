package Sort;

public class Array9 {
    //冒泡排序
    private static void swap(int[] keys,int i,int j){
        int temp = keys[i];
        keys[i]  = keys[j];
        keys[j]  = temp;
    }
    public static void print(int[] keys){
        for(int q : keys){
            System.out.print(q+"\t");
        }
        System.out.println();
    }
    public static void bubbleSort(int[] keys){
        bubbleSort(keys,true);
    }

    public static void bubbleSort(int[] keys,boolean asc){  //asc为 true 升序 否则 降序
        System.out.println("bubbleSort("+(asc ? "up)":"down)") );
        boolean exchange = true;
        for(int i=1; i<keys.length && exchange; i++){
            exchange = false;
            for(int j=0;j<keys.length-i;j++){
                if(asc ? keys[j]>keys[j+1] : keys[j]<keys[j+1] ){
                    swap(keys,j,j+1);
                    exchange = true;
                }
            }
            System.out.print(i+" : "); print(keys);
        }
    }

    public static void main(String[] args) {
        int[] keys = {58,75,97,15,65,32,48,74,56,14};
        bubbleSort(keys);
    }
}
