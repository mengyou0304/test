package com.robin4;

/**
 * Created by robinmac on 15-9-12.
 */
public class SearchInsertPositions {
    public int searchInsert(int[] nums, int t) {
        int st=0;
        int ed=nums.length-1;
        while(st<=ed){
            int mid=(st+ed)/2;
            if(nums[mid]==t)
                return mid;
            if(nums[mid]<t)
                st=mid+1;
            if(nums[mid]>t)
                ed=mid;
        }
        if(nums[st]==t)
            return st;
        if(nums[ed]==t)
            return ed;
        return st;
    }

    public static void main(String[] args) {
        SearchInsertPositions m=new SearchInsertPositions();
        int[] nums=new int[100];
        for(int i=0;i<nums.length;i++)
            nums[i]=i;
        for(int i=0;i<nums.length;i++)
            System.out.println(m.searchInsert(nums,i));

//        System.out.println(m.searchInsert(new int[]{1}));


    }

}
