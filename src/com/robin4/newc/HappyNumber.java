package com.robin4.newc;

import java.util.HashSet;

/**
 * Created by robinmac on 15-9-6.
 */
public class HappyNumber {
    HashSet<Integer> set=new HashSet<Integer>();

    public boolean isHappy(int n) {
        System.out.println("testing...: "+n+" "+set);
        set.add(n);
        int sum=0;
        while(n>0){
            int k=n/10;
            int yu=n-k*10;
            sum+=yu*yu;
            n=k;
        }
        if(sum==1)
            return true;
        if(set.contains(sum))
            return false;
        return isHappy(sum);
    }

    public static void main(String[] args) {
        HappyNumber hn=new HappyNumber();
        boolean ishappy=hn.isHappy(2);
        System.out.println(ishappy);
    }

}
