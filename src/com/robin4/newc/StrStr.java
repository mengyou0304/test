package com.robin4.newc;

import cn.jsi.buaa.basic.DataGen;

/**
 * Created by robinmac on 15-9-5.
 */
public class StrStr {
    public int strStr(String s1, String s2) {
        if(s1.length()==0&&s2.length()==0)
            return 0;
        if(s2.length()==0)
            return 0;
        if(s1.length()==0)
            return -1;
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int j=0;
        int[] next=getNext(c2);
        for(int i=0;i<c1.length;i++){
            while(j>0&&c1[i]!=c2[j])
                j=next[j];
            if(c1[i]==c2[j])
                j++;
            if(j>=c2.length)
                return i-j+1;
        }
        return -1;
    }

    private int[] getNext(char[] c2) {
        int[] next=new int[c2.length+1];
        int j=0;
        for(int i=1;i<c2.length;i++){
            while(j>0&&c2[i]!=c2[j])
                j=next[j];
            if(c2[i]==c2[j])
                j++;
            next[i+1]=j;
        }
        return next;
    }

    public static void main(String[] args) {
        StrStr ss=new StrStr();
        DataGen.showArray(ss.getNext("abc abc d".toCharArray()));
//        System.out.println(ss.strStr("abc abc abc abc abc d", "abc abc d"));
//        System.out.println(ss.strStr("", "abc abc d"));
//        System.out.println(ss.strStr("aaa", ""));
        System.out.println(ss.strStr("ab", "ab"));
        System.out.println(ss.strStr("abc", "ab"));
        System.out.println(ss.strStr("a", "a"));




    }
}
