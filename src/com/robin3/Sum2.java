package com.robin3;

public class Sum2 {
	public int[] twoSum(int[] nums, int t) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int v=t-nums[start]-nums[end];
            if(v==0){
                int[] res=new int[2];
                res[0]=start;
                res[1]=end;
                return res;
            }
            if(v>0)
                end--;
            else
                start++;
        }
        return new int[2];
    }

}
