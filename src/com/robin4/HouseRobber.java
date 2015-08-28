package com.robin4;

/**
 * Created by robinmac on 15-8-27.
 */
public class HouseRobber {

    public int s3(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int pre=nums[0];
        int last=Math.max(pre,nums[1]);
        int cu=0;
        for(int i=2;i<nums.length;i++) {
            cu = Math.max(nums[i] + pre, last);
            pre=last;
            last=cu;
        }
        return last;
    }

    public int s2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        return dp[nums.length-1];
    }

    public int rob(int[] nums) {
        int[][] dp=new int[nums.length+5][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums[i]+dp[i-1][0];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        HouseRobber hr=new HouseRobber();
        int v=hr.s2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(v);
    }
}
