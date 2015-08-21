package com.robin3;

import java.util.ArrayList;
import java.util.List;

import cn.jsi.buaa.basic.Interval;

public class MergInterval {
	public void swap(int i, int j, List<Interval> inlist) {
		Interval ti = inlist.get(i);
		inlist.set(i, inlist.get(j));
		inlist.set(j, ti);
	}

	public int partition(List<Interval> inlist, int st, int ed) {
		int x = inlist.get(ed).start;
		int i = st - 1;
		for (int j = st; j < ed; j++)
			if (inlist.get(j).start < x)
				swap(++i, j, inlist);
		swap(++i, ed, inlist);
		return i;
	}

	public void qsortlist(List<Interval> inlist, int start, int end) {
		if (start >= end)
			return;
		int i = partition(inlist, start, end);
		qsortlist(inlist, start, i - 1);
		qsortlist(inlist, i + 1, end);
	}

	public List<Interval> merge(List<Interval> inlist) {
		return s1(inlist);
	}

	public List<Interval> s1(List<Interval> inlist) {
		qsortlist(inlist, 0, inlist.size() - 1);
		List<Interval> reslist = new ArrayList<Interval>();
		if(inlist.size()<1)
			return reslist;
		Interval cinterval = inlist.get(0);
		for (int i = 1; i < inlist.size(); i++) {
			if (inlist.get(i).start <= cinterval.end) {
				if(inlist.get(i).end>cinterval.end)
					cinterval.end = inlist.get(i).end;
			}
			else {
				reslist.add(cinterval);
				cinterval = inlist.get(i);
			}
		}
		reslist.add(cinterval);
		return reslist;
	}

	class Stree {
		public Stree(int start, int end) {
			this.start=start;
			this.end=end;
		}
		int start;
		int end;
		Stree left;
		Stree right;
		boolean color = false;
	}

	public List<Interval> s2(List<Interval> inlist) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Interval interval : inlist) {
			min = Math.min(min, interval.start);
			max = Math.max(max, interval.end);
		}
		Stree head = new Stree(min,max);
		for (Interval interval : inlist) {
			insert2(head, interval.start,interval.end);
		}
		return genRes(head);
	}

	private List<Interval> genRes(Stree head) {
		List<Interval> list=new ArrayList<Interval>();
		if(head==null)
			return list;
		if(head.color)
			list.add(new Interval(head.start,head.end));
		else{
			list.addAll(genRes(head.left));
//			list.addAll(genRes(head.right));
			List<Interval> l2=genRes(head.right);
			int i=0;
			if(l2.size()>0&&list.size()>0&&list.get(list.size()-1).end==l2.get(0).start){
				list.get(list.size()-1).end=l2.get(0).end;
				i=1;
			}
			for(int j=i;j<l2.size();j++)
				list.add(l2.get(j));
		}
		return list;
	}

	public void insert2(Stree head,int a,int b){
		if(a>=b||head.color){
			return;
		}
		if(a==head.start&&b==head.end){
			head.color=true;
			return;	
		}
		int mid=(head.start+head.end)/2;
		if(head.left==null)
			head.left=new Stree(head.start,mid);
		if(head.right==null)
			head.right=new Stree(mid,head.end);
		insert2(head.left,a,Math.min(mid,b));
		insert2(head.right,Math.max(a, mid),b);
	}
	public static void main(String[] args) {
		MergInterval mi=new MergInterval();
		List<Interval> testlist=new ArrayList<Interval>();
		testlist.add(new Interval(0,1));
		testlist.add(new Interval(2,3));
		testlist.add(new Interval(4,5));
		testlist.add(new Interval(6,7));
		
		testlist.add(new Interval(1,2));
		testlist.add(new Interval(3,4));
		testlist.add(new Interval(5,6));
		
		List<Interval> reslist1=mi.s1(testlist);
		List<Interval> reslist2=mi.s2(testlist);
		System.out.println("**S1 Res**\n\n");
		for(Interval interval:reslist1)
			System.out.println(interval.start+","+interval.end);
		System.out.println("**S2 Res**\n\n");
		for(Interval interval:reslist2)
			System.out.println(interval.start+","+interval.end);
	
	}

}
