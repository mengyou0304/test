package com.robin4;

/**
 * Created by robinmac on 15-8-31.
 */
public class ShortestPalindroms2 {

    public String shortestPalindrome(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] cc = s.toCharArray();

        return "";
    }

    public static void main(String[] args) {
        ShortestPalindroms2 sp=new ShortestPalindroms2();
        String res=sp.shortestPalindrome("ba");
        System.out.println("res="+res);
    }
}
