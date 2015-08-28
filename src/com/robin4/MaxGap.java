package com.robin4;

/**
 * Created by robinmac on 15-8-27.
 */
public class MaxGap {
    Double gap=0d;
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    //find gap by value (0,n-2)
    // gap = 1d*(max-min)/(n-1)
    public int getIndex(int v){
        Double d=1d*(v-min)/gap;
        return d.intValue();

    }
    public int maximumGap(int[] nums) {
        if(nums.length<2)
            return 0;
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        gap=1d*(max-min)/(nums.length-1);
        return -1;
    }
}
