package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Sum3 {
	int[] n;

	public int partition(int start, int end) {
		int x = end;
		int i = start - 1;
		int tmp;
		for (int j = start; j < end; j++) {
			if (n[j] <= n[x]) {
				i++;
				tmp = n[i];
				n[i] = n[j];
				n[j] = tmp;
			}
		}
		i++;
		tmp = n[x];
		n[x] = n[i];
		n[i] = tmp;
		return i;
	}

	public void qsort(int start, int end) {
		if (start > end)
			return;
		int i = partition(start, end);
		qsort(start, i - 1);
		qsort(i + 1, end);

	}

	ArrayList<ArrayList<Integer>> reslist = new ArrayList<ArrayList<Integer>>();

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		n = num;
		qsort(0, n.length - 1);
		Integer li=null;
		for (int i = 0; i < n.length; i++) {
			if(li!=null&&li==n[i])
				continue;
			li=n[i];
			int target = -n[i];
			int start = i + 1;
			int end = n.length - 1;
			while (start < end) {
				//find target from current start,end
				while (n[start] + n[end] != target&&start<end) {
					if (n[start] + n[end] < target)
						start++;
					else
						end--;
				}
			//	System.out.println("i= "+i+"  start="+start+" end="+end);
				// equals to target once but maybe more
				if(start>=end)
					break;
				addRes(n[i], n[start], n[end]);
				//remove the replicated data
				while(start<end&&start<n.length-1&&n[start]==n[start+1])
					start++;
				start++;
				while(start<end&&end>1&&n[end]==n[end-1])
					end--;
				end--;
			}
		}
		return reslist;
	}

	private void addRes(int i, int j, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(i);
		list.add(j);
		list.add(k);
		reslist.add(list);
	}

	public static void main(String[] args) {
		Sum3 s = new Sum3();
		
		int[] input=new int[] { 7, -1, 14,
				-12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15,
				-6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2,
				-15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9,
				-8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12,
				-2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14,
				3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13,
				14, -2, -5, -11, 1, 3, -6 };
	
		long d1=System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> res = s.threeSum(input);
		long d2=System.currentTimeMillis();
		long time=d2-d1;
		System.out.println("time: "+time);
		System.out.println(res);
		res.clear();
		
		input=new int[]{-1,-1,0,1,1};
		res = s.threeSum(input);
		System.out.println("********");
		System.out.println(res);
		res.clear();
		
		input=new int[]{0,0,0};
		res = s.threeSum(input);
		System.out.println("********");
		System.out.println(res);
		res.clear();
		
		input=new int[]{0,0};
		res = s.threeSum(input);
		System.out.println("********");
		System.out.println(res);
		res.clear();
		
		
		input=new int[]{0,0,0,0,0};
		res = s.threeSum(input);
		System.out.println("********");
		System.out.println(res);
	}
	
}
