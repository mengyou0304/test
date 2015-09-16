package com.robin4.newc;

import java.util.Arrays;

/**
 * Created by robinmac on 15-9-7.
 */
public class HIndex {
    public int hIndex(int[] ci) {
        if(ci.length==0)
            return 0;
        Arrays.sort(ci);
        int max=0;
        for(int i=0;i<ci.length;i++){
            int k=ci.length-i;
            int h=ci[i];
            System.out.println(h+" "+k);
            if(k>=h)
                max=Math.max(max,h);
            else
                max = Math.max(k,max);
        }
        return max;
    }

    public static void main(String[] args) {
        HIndex hi=new HIndex();
        int res=hi.hIndex(new int[]{1,2,3,4,5,6});
        System.out.println(res);

    }
}
