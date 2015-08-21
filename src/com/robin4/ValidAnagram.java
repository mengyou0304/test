package com.robin4;

/**
 * Created by robinmac on 15-8-7.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        Long[] counts=new Long[255];
        for(int i=0;i<counts.length;i++)
            counts[i]=0l;
        for(char c:c1)
            counts[c]++;
        for(char c:c2)
            counts[c]--;
        for(long l:counts)
            if(l!=0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram m=new ValidAnagram();
        boolean v=m.isAnagram("abc","cda");
        System.out.println(v);

    }
}
