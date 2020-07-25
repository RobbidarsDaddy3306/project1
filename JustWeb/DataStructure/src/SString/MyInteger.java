package SString;

public class MyInteger implements Comparable<MyInteger> {
    public static final int MIN_VALUE = 0x80000000;  //最小值常量
    public static final int MAX_VAlUE = 0x7fffffff;  //最大值常量

    private final int value;  //私有最终变量 存储整数  赋值一次
    public MyInteger(int value){
        this.value = value;
    }
    //构造方法 字符串转成整型
    public MyInteger(String s) throws NumberFormatException{
        this.value = MyInteger.parseInt(s,10);
    }

    public int intValue(){     //返回整数值
        return this.value;
    }

    public String toString(){  //返回描述字符串
        return this.value+"";
    }

    public boolean equals(Object obj){  //比较对象是否相等
        return obj instanceof Integer && this.intValue()==((Integer)obj).intValue();
    }

    public int compareTo(MyInteger iobj){
        return this.value<iobj.value ? -1:(this.value==iobj.value ? 0:1);
    }
    //将字符串转成整型
    public static int parseInt(String s) throws NumberFormatException{
        return MyInteger.parseInt(s,10);
    }
    public static int parseInt(String s,int radix) throws NumberFormatException{
        if(s==null){
            throw new NumberFormatException("null");
        }
        if(radix<2 || radix>16){
            throw new NumberFormatException("radix="+radix+",Radix is out of range");
        }

        int value=0;int i=0;
        int sign = s.charAt(0) =='-' ? -1:1; //符号位 判断是否是负数
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            if(s.length()==1){                              //只有 + - 符号
                throw new NumberFormatException("\""+s+"\"");
            }else {
                i++;                        //i记住当期字符序号
            }
        }
        while (i<s.length()){              //获得无符号整数的绝对值
            char ch = s.charAt(i++);
            if(ch>'0' && ch-'0'<radix){      //2-10进制
                value = value*radix+ch-'0';
            }else{
                if(radix>10 && radix<=16 && ch>='a'&& ch-'a'<radix-10){
                    value = value*radix+ch-'a'+10;
                }else {
                    if(radix>10 && radix<=16 && ch>='A' && ch-'A'<radix-10){
                        value = value*radix+ch-'A'+10;
                    }else {
                        throw new NumberFormatException(radix+"进制不能识别"+ch);
                    }
                }
            }
        }
        return value*sign;  //返回有符号的整数
    }

    public static String toHexString(int value){
        char[] buffer = new char[8];
        for(int i=buffer.length-1;i>=0;i--){
            int bit = value & 15;
            buffer[i] = (char)(bit<=9?bit+'0':bit+'a'-10);
            value>>>=4;
        }
        return new String(buffer);
    }
}
