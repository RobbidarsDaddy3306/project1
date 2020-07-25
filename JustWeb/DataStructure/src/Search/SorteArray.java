package Search;

public class SorteArray {
    //已知value数组元素升序排序，在begin-end范围内，二分查找关键字为key元素，若查找成功则返回下标，否则返回-1

    //二分查找实现
    public static <T extends Comparable<? super T>> int binarySearch(T[] value,int begin,int end,T key){

        while (begin <= end){         //边界有效
            int mid = (begin+end)/2;
            if(key.compareTo(value[mid])==0){
                return mid;
            }
            if(key.compareTo(value[mid])<0){
                end = mid-1;
            }else {
                begin = mid+1;
            }
        }
        return -1;
    }
    public static <T extends Comparable<? super T>> int binarySearch(T[] value,T key){
        return binarySearch(value,0,value.length-1,key);
    }
}
