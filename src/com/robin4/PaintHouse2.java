package com.robin4;

/**
 * Created by robinmac on 15-8-21.
 */
public class PaintHouse2 {

    public int minCostII(int[][] costs) {
        //check
        if(costs==null)
            return -1;
        if(costs.length==0)
            return 0;
        int m=costs[0].length;
        if(m==1)
            return costs[0][0];

        //gogogo
        int minp=-1;
        for(int i=0;i<costs.length;i++){
            int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
            int cmin1p=-1;
            for(int k=0;k<m;k++){
                if(k!=minp)
                    costs[i][k]+=(i==0?0:costs[i-1][0]);
                else
                    costs[i][k]+=(i==0?0:costs[i-1][1]);
                if(costs[i][k]<min1){
                    min1=costs[i][k];
                    cmin1p=k;
                }
            }
            for(int k=0;k<m;k++)
                if(costs[i][k]<min2&&k!=cmin1p)
                    min2=costs[i][k];
            costs[i][0]=min1;
            costs[i][1]=min2;
            minp=cmin1p;
        }
        return Math.min(costs[costs.length-1][0],costs[costs.length-1][1]);
    }

    public static void main(String[] args) {
        PaintHouse2 ph=new PaintHouse2();
        int res=ph.minCostII(new int[][]{new int[]{20,18,4},new int[]{9,9,10}});
        System.out.println(res);
    }

}
