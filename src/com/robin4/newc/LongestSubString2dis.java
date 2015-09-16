//package com.robin4.newc;
//
//import java.util.HashSet;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Created by robinmac on 15-9-14.
// */
//public class LongestSubString2dis {
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        char[] cc=s.toCharArray();
//        if(cc.length<3)
//            return cc.length;
//        int st=0;
//        int max=2;
//        HashSet<Character> set=new HashSet<Character>();
//        for(int i=0;i<cc.length;i++){
//            System.out.println(set.size()+" "+cc[i]);
//            if(set.contains(cc[i]))
//                continue;
//            if(set.size()<2)
//                set.add(cc[i]);
//            else{
//                //set.size==2
//                max=Math.max(max,(i-1)-st+1);
//                set.clear();
//                set.add(cc[i]);
//                set.add(cc[i-1]);
//                int j=i-1;
//                for(;j>=0;j--)
//                    if(cc[j]!=cc[i-1])
//                        break;
//                st=j+1;
//            }
//        }
//        max=Math.max(max,(cc.length-1)-st+1);
//        return max;
//    }
//
//    public static void main(String[] args) {
//        LongestSubString2dis ls2=new LongestSubString2dis();
//        int v=ls2.lengthOfLongestSubstringTwoDistinct("aaccac");
//        System.out.println(v);
//        ReentrantLock lock=new ReentrantLock();
//        ReadWriteLock rw=new ReadWriteLock() {
//            @Override
//            public Lock readLock() {
//                return null;
//            }
//
//            @Override
//            public Lock writeLock() {
//                return null;
//            }
//        }
//    }
//}
