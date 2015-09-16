package com.robin4.newc;

/**
 * Created by robinmac on 15-9-8.
 */
public class PaintFence {

    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        if(n==1)
            return k;
        int same=k;
        int diff=k*(k-1);
        int res=same+diff;
        for(int i=2;i<n;i++){
            int newsame=diff;
            int newdiff=same*(k-1)+diff*(k-1);
            same=newsame;
            diff=newdiff;
            res=same+diff;
        }
        return res;
    }

    public static void main(String[] args) {
        PaintFence pf=new PaintFence();
        System.out.println(pf.numWays(3,3));
    }

}
