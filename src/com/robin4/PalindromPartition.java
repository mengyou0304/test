package com.robin4;

/**
 * Created by robinmac on 15-8-31.
 */
public class PalindromPartition {

    public boolean canPermutePalindrome(String s) {
        char[] cc=s.toCharArray();
        int k=0;
        for(char c:cc)
            k=k^c;
        if(k==0)
            return true;
        int num=0;
        for(char c:cc){
            if(c==k)
                num++;
        }
        if((num&1)!=1)
            return false;
        return true;
    }
}
