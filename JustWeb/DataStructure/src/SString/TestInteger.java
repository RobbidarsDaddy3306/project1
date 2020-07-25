package SString;

public class TestInteger {
    public static void main(String[] args) {
        MyInteger myint = new MyInteger("125");
//        System.out.println(myint);
        int value = MyInteger.parseInt("574",16);
        System.out.println(value+",0x"+MyInteger.toHexString(value));

    }
}
