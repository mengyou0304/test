package com.robin4;

/**
 * Created by robinmac on 15-9-7.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
        }
        sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum+=nums[i];
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
        }
        return max;
    }
}
