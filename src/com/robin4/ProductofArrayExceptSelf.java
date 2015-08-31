package com.robin4;

import cn.jsi.buaa.basic.DataGen;

import java.util.Arrays;

/**
 * Created by robinmac on 15-8-28.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,1);
        for(int i=0;i<nums.length;i++)
            res[i]=(i==0?1:res[i-1])*nums[i];
        int k=1;
        for(int i=nums.length-1;i>=0;i--) {
            res[i] = (i == 0 ? 1 : res[i - 1]) * k;
            k=k*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf pe=new ProductofArrayExceptSelf();
        DataGen.showArray(pe.productExceptSelf(new int[]{1, 2, 3, 4, 5}));
    }
}
