package com.robin4;

import java.util.ArrayList;

/**
 * Created by robinmac on 15-8-25.
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int x=0;
        for(int i:nums)
            x=x^i;
        int k=x&(-x);
        System.out.println("k="+k);
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        for(int i:nums){
            if((k&i)!=0)
                l1.add(i);
            else
                l2.add(i);
        }
        int x1=0,x2=0;
        System.out.println(l1);
        System.out.println(l2);
        for(int i:l1)
            x1=x1^i;
        for(int i:l2)
            x2=x2^i;
        return new int[]{x1,x2};
    }

    public static void main(String[] args) {
        SingleNumber3 sn=new SingleNumber3();
        sn.singleNumber(new int[]{0,0,1,2});
    }
}
