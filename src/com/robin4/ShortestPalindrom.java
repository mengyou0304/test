package com.robin4;

/**
 * Created by robinmac on 15-8-31.
 */
public class ShortestPalindrom {

    public String shortestPalindrome(String s) {
        if(s==null||s.length()==0)
            return "";
        char[] cc = s.toCharArray();
        int minchar = cc.length;
        int finishpos = -1;
        for (int i = cc.length / 2; i >= 0; i--) {
            for (int delta = 0; i+delta<cc.length&&i - delta >= 0; delta++) {
                if (cc[i - delta] != cc[i + delta])
                    break;
                if (i - delta == 0 && minchar > cc.length - 1 - (i + delta)) {
                    minchar=cc.length - 1 - (i + delta);
                    finishpos = i + delta + 1;
                }
            }
        }
        for (int i = cc.length / 2; i >= 0; i--) {
            for (int delta = 0; i+1+delta<cc.length&&i - delta >= 0; delta++) {
                if (cc[i - delta] != cc[i + delta + 1])
                    break;
                if (i - delta == 0 && minchar > cc.length - (i + delta))
                    minchar=cc.length  - (i + delta);
                    finishpos = i + delta + 2;
            }
        }
        StringBuffer sb=new StringBuffer();
        for(int i=cc.length-1;i>=finishpos;i--)
            sb.append(cc[i]);
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args) {
        ShortestPalindrom sp=new ShortestPalindrom();
        String res=sp.shortestPalindrome("ba");
        System.out.println("res="+res);
    }
}
