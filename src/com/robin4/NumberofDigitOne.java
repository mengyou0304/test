package com.robin4;

/**
 * Created by robinmac on 15-8-7.
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int[] nums=new int[32];
        int sum=0;
        int spliter=10;
        for(int i=1;i<nums.length;i++){
            int deltanum=n%spliter-spliter/10;
            if(deltanum<0)
                deltanum=-1;
            if(deltanum>=10)
                deltanum=9;
            deltanum++;
            System.out.println("deltanum:"+deltanum+ "\t spliter:"+n/spliter);
            nums[i]=n/spliter+deltanum;
            spliter=spliter*10;
        }
        for(int i:nums)
            sum+=i;
        return sum;
    }

    public static void main(String[] args) {
        NumberofDigitOne m=new NumberofDigitOne();
        System.out.println(m.countDigitOne(1));
    }
}
