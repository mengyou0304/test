package com.robin4.newc;

import cn.jsi.buaa.basic.DataGen;

/**
 * Created by robinmac on 15-9-10.
 */
public class StrSt2 {
    public static void main(String[] args) {
        StrSt2 ss=new StrSt2();
        DataGen.showArray(ss.getNext("abc abc d".toCharArray()));
//        System.out.println(ss.strStr("abc abc abc abc abc d", "abc abc d"));
//        System.out.println(ss.strStr("", "abc abc d"));
//        System.out.println(ss.strStr("aaa", ""));
        System.out.println(ss.strStr("ab", "ab"));
        System.out.println(ss.strStr("abc", "ab"));
        System.out.println(ss.strStr("a", "a"));
    }

    private int strStr(String s1, String s2) {
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int j=0;
        int[] next=getNext(c2);
        for(int i=0;i<c1.length;i++){
            while(j>0&&c1[i]!=c2[j])
                j=next[j];
            if(c1[i]==c2[j])
                j++;
            if(j==c2.length)
                return i-j+1;
        }
        return -1;
    }

    private int[] getNext(char[] cc) {
        int[] next=new int[cc.length+1];
        int j=0;
        for(int i=1;i<cc.length;i++){
            while(j>0&&cc[i]!=cc[j])
                j=next[j];
            if(cc[i]==cc[j])
                j++;
            next[i+1]=j;
        }
        return next;
    }

}
