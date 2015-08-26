package com.robin4;

/**
 * Created by robinmac on 15-8-25.
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int three=0,two=0,one=0;
        for(int i:nums){
            //first remove current 3
            int jin3=two&one;
            two=two&(~jin3);
            one=one&(~jin3);
            //then find 2 +i =jin3
            jin3=two&i;
            two=two&(~jin3);
            i=i&(~jin3);
            //then find i+i=jin2
            int jin2=one&i;
            one=one&(~jin2);
            two=two|jin2;
            one=one|(i&~jin2);
        }
        return one;
    }
}
