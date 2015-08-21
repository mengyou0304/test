package com.robin4;

/**
 * Created by robinmac on 15-8-21.
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs==null)
            return -1;
        int len=costs.length;
        if(len==0)
            return 0;
        int[][] dp=new int[len][3];
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];
        for(int i=1;i<len;i++)
            for(int k=0;k<3;k++)
                dp[i][k]=costs[i][k]+Math.min(dp[i-1][(k+1)%3],dp[i-1][(k+2)%3]);
        int v=dp[len-1][0];
        v=Math.max(v,dp[len-1][1]);
        v=Math.max(v,dp[len-1][2]);
        return v;
    }
}
