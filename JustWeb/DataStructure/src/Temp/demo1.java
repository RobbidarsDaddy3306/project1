package Temp;

import SString.MyString;

import java.util.*;

public class demo1 {
    public static void checkStr(String str) {

        Map<Character, Integer> word = new HashMap<Character, Integer>();

        char[] ch = str.toCharArray();

        for(int i=0;i<str.length();i++){
            if(word.containsKey((str.charAt(i)))){
                word.put(ch[i],word.get(ch[i])+1);
            }else {
                word.put(ch[i],1);
            }
        }

        System.out.println(word);

    }

    public static void main(String[] args) {
      checkStr("adasddasdf");

    }
}
