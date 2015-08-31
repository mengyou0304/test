//package com.robin4;
//
//import cn.jsi.buaa.basic.DataGen;
//
//import java.util.Arrays;
//
///**
// * Created by robinmac on 15-8-28.
// */
//public class SlidingWindow {
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums==null||nums.length==0||k==0)
//            return new int[]{};
//        int[] res=new int[nums.length-k+1];
//        Arrays.fill(res, Integer.MIN_VALUE);
//        for(int i=0;i<res.length;i++){
//            for(int j=i-3)
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        SlidingWindow sw=new SlidingWindow();
//        DataGen.showArray(sw.maxSlidingWindow(new int[]{9, 11}, 2));
//    }
//}
