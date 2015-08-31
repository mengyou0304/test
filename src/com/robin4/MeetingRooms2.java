package com.robin4;

import cn.jsi.buaa.basic.Interval;

/**
 * Created by robinmac on 15-8-29.
 */
public class MeetingRooms2 {


    public int minMeetingRooms(Interval[] ins) {
        int st=Integer.MAX_VALUE;
        int ed=Integer.MIN_VALUE;
        for(Interval in: ins){
            st=Math.min(st,in.start);
            ed=Math.max(ed,in.end);
        }
        int[] bis=new int[ed-st+5];
        int delta=st-1;
        for(Interval in:ins){
            add(in.start-delta,-1,bis);
            add(in.end-delta,1,bis);
        }
        int max=0;
        for(int i=1;i<bis.length;i++){
            max=Math.max(max,getFrom(bis,i));
        }
        return max;
    }

    private int getFrom(int[] bis, int i) {
        int res=0;
        while(i<bis.length){
            res+=bis[i];
            i+=i&(-i);
        }
        return res;
    }

    private void add(int index,int added,int[] b){
        while(index>0){
            b[index]+=added;
            index-=index&(-index);
        }
    }

    public static void main(String[] args) {
        MeetingRooms2 mr=new MeetingRooms2();
//        int[] vs=new int[]{0,1,2,3,4,5,9,7,8,9};
        int[] vs=new int[]{1,8,4,6,3,5};

        Interval[] ins=new Interval[vs.length/2];
        for(int i=0;i<ins.length;i++){
            ins[i]=new Interval(vs[i*2], vs[i * 2 + 1]);
        }
        System.out.println(mr.minMeetingRooms(ins));
    }
}

