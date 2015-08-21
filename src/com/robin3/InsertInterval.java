package com.robin3;

import java.util.ArrayList;
import java.util.List;

import cn.jsi.buaa.basic.Interval;

public class InsertInterval {
	public List<Interval> insert(List<Interval> ilist, Interval newv) {
        ArrayList<Interval> reslist=new ArrayList<Interval>();
        boolean addnew=false;
        for(Interval iv:ilist){
            if(newv.start>iv.start&&newv.start<=iv.end)
                newv.start=iv.start;
            if(newv.end>=iv.start&&newv.end<iv.end)
                newv.end=iv.end;
            if(iv.end>newv.start&&!addnew){
                addnew=true;
                reslist.add(newv);
            }
            if(!(iv.start>=newv.start)||!(iv.end<=newv.end))
                reslist.add(iv);
        }
        if(!addnew)
        		reslist.add(newv);
        return reslist;
    }
	public static void main(String[] args) {
		InsertInterval ii=new InsertInterval();
		ArrayList<Interval> list=new ArrayList<Interval>();
//		list.add(new Interval(2,4));
//		list.add(new Interval(5,6));
//		list.add(new Interval(7,9));
//		list.add(new Interval(14,16));
		
		List<Interval> list2=ii.insert(list, new Interval(10,11));
		for(Interval iv:list2)
			System.out.println(iv.start+","+iv.end);
	}

}
