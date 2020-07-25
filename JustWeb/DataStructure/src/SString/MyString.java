package SString;

import java.util.Arrays;

public class MyString implements Comparable<MyString>,java.io.Serializable  {
    private final char[] value;        //字符数组 私有最终变量

    public MyString(){                //构造空串
        this.value = new char[0];
    }

    public MyString(java.lang.String str){
        this.value = new char[str.length()];
        for(int i=0;i<this.value.length;i++){
            this.value[i] = str.charAt(i);
        }
    }


    //以value数组从i开始的n个字符构造串 ,i>=0 n>=0 i+n<=value
    public MyString(char[] value,int i,int n){
        if(i>=0 && n>=0 && i+n<=value.length){
            this.value = new char[n];
            for(int j=0;j<n;j++){
                this.value[j] = value[i+j];
            }
        }else {
            throw new StringIndexOutOfBoundsException("i="+i+",n="+n+",i+n="+(i+n));
        }
    }

    public MyString(char[] value){
        this(value,0,value.length);
    }

    public MyString(MyString str){  //拷贝构造方法   深拷贝
        this(str.value);
    }

    public int length(){  //返回字符串长度 即字符串数组容量
        return this.value.length;
    }

    public java.lang.String toString(){
        return new String(this.value);
    }

    public char charAt(int i){
        if(i>=0 && i<this.value.length){
            return this.value[i];
        }else {
            throw new StringIndexOutOfBoundsException(i);
        }
    }
     //截取子串
    public MyString substring(int begin,int end){
        if(begin==0 && end==this.value.length){
            return this;
        }else {
            return new MyString(this.value,begin,end-begin);
        }
    }
    //方法重载
    public MyString substring(int begin){
        return substring(begin,this.value.length);
    }
    //连接串
    public MyString concat(MyString str){
        if(str==null){
            str = new MyString("null");
        }
        char[] buffer = new char[this.value.length+str.length()];
        int i;
        for(i=0;i<this.value.length;i++){
            buffer[i] = this.value[i];
        }
        for(int j=0;j<str.value.length;j++){
            buffer[i+j] = str.value[j];
        }
        return new MyString(buffer);
    }

    //判断是否含有某个字符

    public boolean isContanined(char ch){
        for(int i=0;i<this.value.length;i++){
            if(value[i] == ch){
                return true;
            }
        }
        return false;
    }



    //比较两串是否相等
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        o = (MyString)o;
        boolean flag = true;
        if(this.length() == ((MyString) o).length()){
            for(int i=0;i<this.length();i++){
                if(this.charAt(i)!=((MyString) o).charAt(i)){
                    flag = false;
                }
            }
        }else {
            return false;
        }
        return flag;
    }
    //比较串的大小
    public int compareTo(MyString str){
        for(int i=0;i<this.length() && i<str.length();i++){
            if(this.value[i]!=str.value[i]){
                return this.value[i] - str.value[i];
            }
        }
        return this.length()-str.length();
    }

    //KMP算法
    public static int indexOf(String target,String pattern){
        return indexOf(target,pattern,0);
    }

    public static int indexOf(String target,String pattern,int begin){
        int n = target.length();
        int m = pattern.length();

        if(begin<0){    //容错操作
            begin = 0;
        }
        if(n==0 || n<m || begin>=n){
            return -1;
        }
        int[] next = getNext(pattern);
        int i = begin;
        int j = 0;
        while (i<n && j<m){
            if(j==-1 || target.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
                if(n-i+1<m-j+1){
                    break;
                }
            }
        }
        if(j == m){
            return i-j;
        }
        return -1;
    }
    //next的getNext方法
    private static int[] getNext(String pattern){
        int j = 0;
        int k = -1;
        int next[] = new int[pattern.length()];
        next[0] = -1;
        while (j<pattern.length()-1){
            if(k==-1 || pattern.charAt(j) == pattern.charAt(k)){
                j++;
                k++;
                next[j] = k;
            }else {
                k = next[k];
            }
        }
        return next;
    }


}
