package com.robin3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.robin3.utility.DataGen2;

public class Sum4 {
	public void swap(int[] num, int i, int j) {
		int v = num[i];
		num[i] = num[j];
		num[j] = v;
	}

	public int partition(int[] num, int start, int end) {
		int x = num[end];
		int j = start - 1;
		for (int i = start; i < end; i++)
			if (num[i] < x)
				swap(num, ++j, i);
		swap(num, ++j, end);
		return j;
	}

	public void qsort(int[] num, int start, int end) {
		if (start >= end)
			return;
		int i = partition(num, start, end);
		qsort(num, start, i - 1);
		qsort(num, i + 1, end);
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		qsort(num, 0, num.length - 1);
		HashMap<Integer, List<String>> sum2 = new HashMap<Integer, List<String>>();
		List<List<Integer>> rlist = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j < num.length; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;
				String s = "" + num[i] + " " + num[j];
				int sum = num[i] + num[j];
				// genRes
				List<String> list2 = sum2.get(0 - sum);
				if (list2 != null)
					for (String s2 : list2) {
						String[] ss = s2.split(" ");
						ArrayList<Integer> reslist = new ArrayList<Integer>();
						reslist.add(Integer.parseInt(ss[0]));
						reslist.add(Integer.parseInt(ss[1]));
						reslist.add(num[i]);
						reslist.add(num[j]);
				//		Collections.sort(reslist);
						rlist.add(reslist);
					}
				// add to map
				List<String> list = sum2.get(sum);
				if (list == null) {
					list = new ArrayList<String>();
					sum2.put(sum, list);
				}
				list.add(s);

			}
		}
		return rlist;
	}

	public static void main(String[] args) {
		Sum4 s4 = new Sum4();
		DataGen2.ShowLL2(s4.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
	}

}
