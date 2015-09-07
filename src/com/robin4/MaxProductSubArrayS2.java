package com.robin4;

/**
 * Created by robinmac on 15-8-28.
 */
public class MaxProductSubArrayS2 {

    public int maxProduct(int[] nums) {
        int maxv=Integer.MIN_VALUE;
        int cv=1;
        boolean allzero=true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                allzero=false;
            cv=cv*nums[i];
            maxv=Math.max(maxv,cv);
            if(cv==0)
                cv=1;
        }
        cv=1;
        for(int i=nums.length-1;i>=0;i--){
            cv=cv*nums[i];
            maxv=Math.max(maxv,cv);
            if(cv==0)
                cv=1;
        }
        if(allzero)
            return 0;
        return maxv;
    }



    public static void main(String[] args) {
        MaxProductSubArrayS2 mp = new MaxProductSubArrayS2();
        int res = mp.maxProduct(new int[]{-1,-1,-3, 0, -2});
        System.out.println(res);
        System.out.println("hah");
        res = mp.maxProduct(new int[]{-2});
        System.out.println(res);
        System.out.println("hah");

        res = mp.maxProduct(new int[]{-3,0,1,-2});
        System.out.println(res);


    }
}
