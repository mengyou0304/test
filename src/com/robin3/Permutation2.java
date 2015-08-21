package com.robin3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.robin3.utility.DataGen2;

public class Permutation2 {
	HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
	ArrayList<List<Integer>> reslist = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] num) {
		for (Integer i : num) {
			Integer v = numMap.get(i);
			if (v == null)
				v = 0;
			numMap.put(i, v + 1);
		}
		dp(0, num, new ArrayList<Integer>());
		return reslist;
	}

	public void dp(int p, int[] num, ArrayList<Integer> list) {
		if (p >= num.length) {
			ArrayList<Integer> tlist = new ArrayList<Integer>();
			for (Integer i : list)
				tlist.add(i);
			reslist.add(tlist);
			return;
		}
		HashSet<Integer> usedSet = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (usedSet.contains(num[i]))
				continue;
			Integer v = numMap.get(num[i]);
			if (v > 0) {
				usedSet.add(num[i]);
				numMap.put(num[i], v - 1);
				list.add(num[i]);
				dp(p + 1, num, list);
				list.remove(list.size() - 1);
				numMap.put(num[i], v );
			}
		}
	}
	public static void main(String[] args) {
		Permutation2 pt2=new Permutation2();
		DataGen2.ShowLL2(pt2.permuteUnique(new int[]{1,1,2}));
	}

}
