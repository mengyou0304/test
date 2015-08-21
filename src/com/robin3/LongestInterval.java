package com.robin3;

import java.util.ArrayList;

import cn.jsi.buaa.basic.Interval;

public class LongestInterval {
	int maxv=0;
	ITreeNode maxNode=null;
	int len=0;
	public class IndexTree {
		ITreeNode head;
		public IndexTree(int min, int max) {
			head=new ITreeNode(min,max);
		}
		public void add(Interval ii) {
			realadd(head,ii.start,ii.end);
		}
		private void realadd(ITreeNode head2, int st,int ed) {
			if(head2.st==st&&head2.ed==ed){
			//	System.out.println("setting+1 "+st+","+ed);
				head2.v++;
				return;
			}
			int mid=(head2.st+head2.ed)/2;
			if(st<mid+1){
				if(head2.left==null)
					head2.left=new ITreeNode(head2.st,mid);
				realadd(head2.left,st,Math.min(mid, ed));
			}
			if(mid<ed){
				if(head2.right==null)
					head2.right=new ITreeNode(mid+1,head2.ed);
				realadd(head2.right,Math.max(mid+1,st),ed);
			}
		}
		public ArrayList<Interval> getLongRes(ITreeNode head) {
			ArrayList<Interval> l1=getLongRes(head.left);
			ArrayList<Interval> l2=getLongRes(head.right);
			Interval  inter0=l1.get(0);
			Interval  inter1=l2.get(1);
			Interval  inter2=new Interval (0,-1);
			if(l1.get(1)!=null&&l2.get(0)!=null){
				inter2.start=l1.get(1).start;
				inter2.end=l2.get(0).end;
			}
			if(inter2.end-inter2.start<l1.get(2).end-l1.get(2).start)
				inter2=l1.get(2);
			if(inter2.end-inter2.start<l2.get(2).end-l2.get(2).start)
				inter2=l1.get(2);
			
			ArrayList<Interval> reslist=new ArrayList<Interval>();
			reslist.add(inter0);
			reslist.add(inter1);
			reslist.add(inter2);
			return reslist;
		}
		

	}
	class ITreeNode{
		public ITreeNode(int min, int max) {
			st=min;
			ed=max;
		}
		ITreeNode left;
		ITreeNode right;
		int v;
		int st;
		int ed;
	}

	int min = Integer.MAX_VALUE;
	int max = Integer.MIN_VALUE;

	Interval getLongInterval(ArrayList<ArrayList<Integer>> vlist) {
		len=vlist.size();
		ArrayList<ArrayList<Interval>> ilist = getIntervals(vlist);
		IndexTree tree = new IndexTree(min, max);
		for(ArrayList<Interval> ai:ilist)
			for(Interval ii:ai){
				System.out.println("\n\n Treat interval "+ii.start+" "+ii.end);
				tree.add(ii);
			}
		return tree.getLongRes(tree.head).get(2);
	}

	private ArrayList<ArrayList<Interval>> getIntervals(
			ArrayList<ArrayList<Integer>> vlist) {
		ArrayList<ArrayList<Interval>> ilist=new ArrayList<ArrayList<Interval>>();
		for(ArrayList<Integer> vs:vlist){
			if(vs.size()==0)
				continue;
			min=Math.min(min, vs.get(0));
			max=Math.max(max, vs.get(vs.size()-1));
			Interval p=new Interval();
			Integer lastv=null;
			vs.add(Integer.MIN_VALUE);
			ArrayList<Interval> tlist=new ArrayList<Interval>();
			for(int i:vs){
				if(p.start==null)
					p.start=i;
				if(lastv==null||lastv+1==i)
					lastv=i;
				else{
					p.end=lastv;
					tlist.add(p);
					p=new Interval();
					p.start=i;
					lastv=i;
				}
			}
			ilist.add(tlist);
		}
		return ilist;
	}
	public static void main(String[] args) {
		LongestInterval ii=new LongestInterval();
		ArrayList<ArrayList<Integer>> ailist=new ArrayList<ArrayList<Integer>>();
		
		Interval i1=new Interval(1,2);
		Interval i2=new Interval(3,7);
		Interval i3=new Interval(10,100);
		Interval i5=new Interval(104,113);
		ArrayList<Interval> l1=new ArrayList<Interval> ();
		l1.add(i1);
		l1.add(i3);
		l1.add(i5);
		ArrayList<Interval> l2=new ArrayList<Interval> ();
		l2.add(i3);
		l2.add(i5);
		ailist.add(genArray(l1));
		ailist.add(genArray(l2));
		Interval interval=ii.getLongInterval(ailist);
		System.out.println("\n\nres: "+interval.start+","+interval.end);
	}
	public static ArrayList<Integer> genArray(ArrayList<Interval> inlist){
		ArrayList<Integer>  reslist=new ArrayList<Integer>();
		for(Interval i:inlist){
			for(int j=i.start;j<=i.end;j++)
				reslist.add(j);
		}
		return reslist;
		
	}

}
