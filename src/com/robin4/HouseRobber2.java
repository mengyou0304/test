package com.robin4;

/**
 * Created by robinmac on 15-8-27.
 */
public class HouseRobber2 {
    public int srob(int[] nums,int st,int ed){
        if(ed-st<0)
            return 0;
        if(ed-st==0)
            return nums[ed];
        int pre=nums[st];
        int last=Math.max(pre,nums[st+1]);
        int cu=0;
        for(;st<=ed;st++) {
            cu = Math.max(nums[st] + pre, last);
            pre=last;
            last=cu;
        }
        return last;
    }

    public int rob(int[] nums) {
        int v1=srob(nums,2,nums.length-2)+nums[0];
        int v2=srob(nums,1,nums.length-1);
        return Math.max(v1,v2);
    }

    public static void main(String[] args) {
        HouseRobber2 hr=new HouseRobber2();
        int v=hr.rob(new int[]{1,2,3,4,5,6,7,8,9,0});
        System.out.println(v);
    }
}
