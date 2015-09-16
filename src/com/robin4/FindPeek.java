package com.robin4;

/**
 * Created by robinmac on 15-9-8.
 */
public class FindPeek {
    int[] nums;
    public int findPeakElement(int[] nums) {
        if(nums.length==0)
            return -1;
        this.nums=nums;
        return findPeek(0,nums.length-1);
    }
    private int findPeek(int st,int ed){
//        System.out.println(st+" "+ed);
        if(st==ed)
            return st;
        if(st>ed)
            return findPeek(ed, st);
        if(st==ed-1){
            if(nums[st]>nums[ed])
                return st;
            return ed;
        }
        boolean biggerThanleft=false;
        boolean biggerThanright=false;
        int mid=(st+ed)/2;
        if(mid==0)
            biggerThanleft=true;
        else{
            if(nums[mid]>nums[mid-1])
                biggerThanleft=true;
        }
        if(mid==nums.length-1)
            biggerThanright=true;
        else
            if(nums[mid]>nums[mid+1])
                biggerThanright=true;
        if(biggerThanleft&&biggerThanright)
            return mid;
        if(biggerThanleft)
            return findPeek(mid,ed);
        if(biggerThanright)
            return findPeek(st,mid);
        return findPeek(st,mid-1);
    }

    public static void main(String[] args) {
        FindPeek fp=new FindPeek();
//        System.out.println(fp.findPeakElement(new int[]{1,2,3,4,5,1}));
//        System.out.println(fp.findPeakElement(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(fp.findPeakElement(new int[]{6,3,2,1}));
//        System.out.println(fp.findPeakElement(new int[]{2,1}));
//        System.out.println(fp.findPeakElement(new int[]{1,2}));
        System.out.println(fp.findPeakElement(new int[]{1}));
        System.out.println(fp.findPeakElement(new int[]{}));







    }
}
