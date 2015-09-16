package com.robin4;

/**
 * Created by robinmac on 15-9-10.
 */
public class BestTimeStock2 {

    public int maxProfit(int[] prices) {
        int profit=0;
        Integer buyprice=Integer.MAX_VALUE;
        for(int i:prices){
            if(i>buyprice){
                profit+=(i-buyprice);
            }
            buyprice=i;
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeStock2 b2=new BestTimeStock2();
        System.out.println(b2.maxProfit(new int[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1,2,3,4,5}));
    }
}
