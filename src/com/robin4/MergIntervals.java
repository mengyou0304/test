package com.robin4;

import cn.jsi.buaa.basic.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinmac on 15-8-29.
 */
public class MergIntervals {
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
    public ArrayList<Interval> merge(List<Interval> inlist) {
        if(inlist==null||inlist.size()==0)
            return new ArrayList<Interval>();
        Interval[] ins=inlist.toArray(new Interval[0]);
        qsort(ins, 0, ins.length - 1);
        for(Interval in:ins)
            System.out.println(in);
        ArrayList<Interval> reslist=new ArrayList<Interval>();
        Interval p=new Interval(ins[0].start,ins[0].end);
        for(int i=1;i<ins.length;i++){
            if(p.end<ins[i].start){
                reslist.add(p);
                p=new Interval(ins[i].start,ins[i].end);
            }else{
                p.end=Math.max(p.end,ins[i].end);
            }
        }
        reslist.add(p);
        return reslist;
    }

    public static void main(String[] args) {
        MergIntervals mi=new MergIntervals();
        int[] vs=new int[]{8,9,0,1,2,3,4,5,6,8,};
        Interval[] ins=new Interval[vs.length/2];
        for(int i=0;i<ins.length;i++){
            ins[i]=new Interval(vs[i*2],vs[i*2+1]);
        }
        ArrayList<Interval> list=new ArrayList<Interval>();
        for(Interval in:ins)
            list.add(in);
        list=mi.merge(list);
        System.out.println("RES:");
        for(Interval in:list)
            System.out.println(in);
    }
}
