package com.robin4;

/**
 * Created by robinmac on 15-8-21.
 */
public class PaintHouse2 {

    public int minCostII(int[][] costs) {
        if(costs==null)
            return -1;
        int len=costs.length;
        if(len==0)
            return 0;
        int m=costs[0].length;
        int[][] dp=new int[len+2][m];
        for(int i=1;i<len+2;i++){
            for(int k=0;k<m;k++) {
                dp[i][k]=costs[i-1][m];
                int minv=Integer.MAX_VALUE;
                for(int j=0;j<m;j++){
                    if(j==k)
                        continue;
                    minv=Math.min(minv,dp[i-1][j]);
                }
                dp[i][k]+=minv;
            }
        }
        return Math.min(dp[len+1][0],dp[len+1][1]);
    }

}
