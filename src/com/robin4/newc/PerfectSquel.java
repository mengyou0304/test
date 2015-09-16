package com.robin4.newc;

import java.util.ArrayList;

/**
 * Created by robinmac on 15-9-11.
 */
public class PerfectSquel {
    public int numSquares(int n) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] sub=new int[n+1];
        Double d=Math.sqrt(n);
        for(int i=d.intValue();i>=1;i--)
            list.add(i*i);
        System.out.println(list);
        int[] dp=new int[n+1];
        return getDP(list,dp,n);
    }
    private int getDP(ArrayList<Integer> list, int[] dp,int k){
//        DataGen.showArray(dp);
        if(k==0)
            return 0;
        if(dp[k]!=0)
            return dp[k];
        int min=k;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>k)
                continue;
            min=Math.min(min,getDP(list,dp,k-list.get(i)));
        }
        dp[k]=min+1;
        return min+1;
    }
    public static void main(String[] args) {
        PerfectSquel ps=new PerfectSquel();
        System.out.println(ps.numSquares(12));


    }
}
