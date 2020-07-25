package Temp;

import Stack.SeqStack;

public class ExechangeNumber<T> {
    public static SeqStack stack;
    public static String zhuanhua(int n) {    //10进制以上校验
        String str="";
        String str1="";
        while(n>0) {
            //t为余数
            int t=n%16;
            switch(t) {
                case 10:stack.push(str+'A');
                    break;
                case 11:stack.push(str+'B');
                    break;
                case 12:stack.push(str+'C');
                    break;
                case 13:stack.push(str+'D');
                    break;
                case 14:stack.push(str+'E');
                    break;
                case 15:stack.push(str+'F');
                    break;
                default:stack.push(str+t);
                    break;
            }
            n=n/16;
        }
        while(!stack.isEmpty()) {
            str1=str1+stack.pop();
        }

        //返回一个字符串
        return str1;
    }

    public void exechange(int n, int base){
        stack = new SeqStack<T>();
        while(true){
            if(n<base){
                stack.push(zhuanhua(n)+" ");
                break;
            }
            int rest = n%base;    //余数
            n = n/base;           //商
            stack.push(zhuanhua(rest)+" ");

        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        ExechangeNumber exe = new ExechangeNumber();
        exe.exechange(178,16);
    }
}
