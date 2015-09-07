package com.robin4;

/**
 * Created by robinmac on 15-8-28.
 */
public class MaxProductSubArray {

    private int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int lastv = 1;
        int firstNGv = 1;
        boolean firsttime = true;
        int maxv = Integer.MIN_VALUE;
        //check have bigger than 1
        int cv = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //finish all vs
            if (nums[i] == 0) {
                maxv = Math.max(0, cv);
                if (!firsttime){
                    int nextpart=0;
                    if(firstNGv!=0)
                        nextpart=cv / firstNGv;
                    maxv = Math.max(maxv, Math.max(Math.max(cv, lastv), nextpart));
                }
                cv = 1;
                firstNGv = 1;
                lastv = 1;
                firsttime=true;
            }

            if (nums[i] < 0) {
                if (firsttime) {
                    firsttime = false;
                    firstNGv = cv;
                }
                lastv = cv;
            }
            cv *= nums[i];
            maxv=Math.max(maxv,cv);
        }
        return maxv;
    }


    public static void main(String[] args) {
        MaxProductSubArray mp = new MaxProductSubArray();
        int res = mp.maxProduct(new int[]{-1,-1,-3, 0, -2});
        System.out.println(res);
        res = mp.maxProduct(new int[]{-2});
        System.out.println(res);


    }
}
