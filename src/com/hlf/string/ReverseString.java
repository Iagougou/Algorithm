package com.hlf.string;

public class ReverseString {

    public static String reverseString(String s){
        char[] chars = s.toCharArray();
        int left =0 ,right = chars.length-1;
        while (left<right){
            char temp = chars[left];
            chars[left++]= chars[right];
            chars[right--]= temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.printf(reverseString("hello"));
    }
}
