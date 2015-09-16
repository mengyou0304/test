package com.robin4.newc;

import cn.jsi.buaa.basic.DataGen;

/**
 * Created by robinmac on 15-9-11.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length<2)
            return;
        if(nums.length==2){
            int min=Math.min(nums[0],nums[1]);
            int max=Math.max(nums[0],nums[1]);
            nums[0]=min;
            nums[1]=max;
            return;
        }
        int[] buff=new int[3];
        buff[0]=nums[0];
        buff[1]=nums[1];
        buff[2]=nums[2];
        int i=2;
        int index=-1;
        boolean getSmall=true;
        while(i<nums.length){
            if(getSmall)
                index=getSmallIndex(buff);
            else
                index=getBigIndex(buff);
            nums[i-2]=buff[index];
            buff[index]=nums[i];
            getSmall=!getSmall;
            i++;
        }
        int min=Math.min(buff[(index+1)%3],buff[(index+2)%3]);
        int max=Math.max(buff[(index+1)%3],buff[(index+2)%3]);
        if(getSmall){
            nums[i-2]=min;
            nums[i-1]=max;
        }else{
            nums[i-2]=max;
            nums[i-1]=min;
        }
    }

    private int getSmallIndex(int[] buff){
        int index=0;
        if(buff[0]<=buff[1])
            index=0;
        if(buff[index]>buff[2])
            index=2;
        return index;
    }
    private int getBigIndex(int[] buff){
        int index=0;
        if(buff[0]>=buff[1])
            index=0;
        if(buff[index]<buff[2])
            index=2;
        return index;
    }

    public static void main(String[] args) {
        WiggleSort ws=new WiggleSort();
//        int[] res=new int[]{1,2,3,4,5,6,7,8,9};
        int[] res=new int[]{9,8,7,6,0,5,4,3,1,2,1};

        ws.wiggleSort(res);
        DataGen.showArray(res);
    }
}
