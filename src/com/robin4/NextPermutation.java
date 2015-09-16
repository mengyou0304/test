package com.robin4;

import cn.jsi.buaa.basic.DataGen;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by robinmac on 15-9-7.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int[] n2= Arrays.copyOf(nums,nums.length);
        int largeIndex=-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i-1]>=nums[i])
                continue;
            else{
                largeIndex=i;
                break;
            }
        }
        //don't have any larger  : 4 3 2 1 ->
        if(largeIndex==-1){
            for(int i=0;i<nums.length;i++)
                nums[i]=n2[nums.length-i-1];
            return;
        }

        //have larger:  1 4 4 3 2 1
        //                ^
        //                |
        //               la
        int nlargeIndex=-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[largeIndex-1]){
                nlargeIndex=i;
                break;
            }
        }
        //have larger:  1 4 4 3 2 1
        //                ^     ^
        //                |     |
        //               la    nla
        n2[nlargeIndex]=nums[largeIndex-1];
        nums[largeIndex-1]=nums[nlargeIndex];
        for(int i=largeIndex;i<nums.length;i++)
            nums[i]=n2[nums.length-1-(i-largeIndex)];
    }

    public static void main(String[] args) {
        NextPermutation np=new NextPermutation();
        int[] nums=new int[]{1,2,3,4,5,6};
        np.nextPermutation(nums);
        DataGen.showArray(nums);

        nums=new int[]{1,4,3,2,1};
        np.nextPermutation(nums);
        DataGen.showArray(nums);

    }

}
