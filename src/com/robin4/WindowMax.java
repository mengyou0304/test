package com.robin4;

/**
 * Created by robinmac on 15-8-21.
 */
public class WindowMax {

    //TODO rename according to leetcode
    public int[] maxWindow(int[] ar,int winlen){
        int[] res=new int[ar.length+winlen];
        for(int i=0;i<ar.length;i++)
            for(int j=i;j<i+winlen;j++)
                if(ar[i]>res[j])
                    res[j]=ar[i];
        return res;

    }
}
