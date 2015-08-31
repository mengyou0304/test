package com.robin4;

import cn.jsi.buaa.basic.Interval;

/**
 * Created by robinmac on 15-8-10.
 */
public class MeetingRooms {

    public boolean canAttendMeetings(Interval[] ins) {
        if(ins==null||ins.length==0)
            return true;
        qsort(ins,0,ins.length-1);
        int lastv=Integer.MIN_VALUE;
        for(int i=0;i<ins.length;i++){
            if(ins[i].start<lastv)
                return false;
            lastv=ins[i].end;
        }
        return true;
    }

    private void qsort(Interval[] ins,int start,int end) {
        if(start>=end)
            return;
        int i=partition(ins,start,end);
        qsort(ins,start,i-1);
        qsort(ins,i+1,end);
    }

    private int partition(Interval[] ins, int start, int end) {
        int j=start-1;
        int x=ins[end].start;
        for(int i=start;i<end;i++)
            if(ins[i].start<x)
                swap(++j,i,ins);
        swap(++j,end,ins);
        return j;
    }

    private void swap(int i, int j,Interval[] ins) {
        Interval tmp=ins[i];
        ins[i]=ins[j];
        ins[j]=tmp;
    }

    public static void main(String[] args) {
        MeetingRooms m=new MeetingRooms();
        int[] vs=new int[]{0,1,2,3,4,5,9,7,8,9};
        Interval[] ins=new Interval[vs.length/2];
        for(int i=0;i<ins.length;i++){
            ins[i]=new Interval(vs[i*2],vs[i*2+1]);
        }
        System.out.println(m.canAttendMeetings(ins));
    }
}
