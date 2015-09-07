package com.robin4;

import cn.jsi.buaa.basic.DataGen;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by robinmac on 15-8-28.
 */
public class SlidingWindow {

    Deque<Integer> deqv=new LinkedList<Integer>();
    Deque<Integer> deqlife=new LinkedList<Integer>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k)
            return new int[]{};

        int[] res=new int[nums.length+k];
        int index=0;

        for(int i=0;i<nums.length;i++){
            //Add @last
            while(deqv.size()!=0&&deqv.peekLast()<nums[i]){
                deqv.pollLast();
                deqlife.pollLast();
            }
            deqv.addLast(nums[i]);
            if(deqlife.size()==0)
                deqlife.addLast(k);
            else
                deqlife.addLast(k - deqlife.peekLast()); //??check?

            //Gen max and remove @first
            res[index++]=deqv.peekFirst();
            int life=deqlife.peekFirst();
            if(life==1){
                deqv.pollFirst();
                deqlife.pollFirst();
            }else{
                deqlife.addFirst(deqlife.pollFirst()-1);
            }
        }
        int[] nres=new int[nums.length-k+1];
        int nindex=0;
        for(int i=k-1;i<res.length-(k);i++){
            nres[nindex++]=res[i];
        }
        return nres;
    }

    public static void main(String[] args) {
        SlidingWindow sw=new SlidingWindow();
        int[] res=sw.maxSlidingWindow(new int[]{9,11},2);
        DataGen.showArray(res);
    }
}
