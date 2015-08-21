package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	ArrayList<ArrayList<Integer>> reslist = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> inlist=new ArrayList<Integer>();
	ArrayList<Integer> st = new ArrayList<Integer>();
	
	public void genRes() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=st.size()-1;i>=0;i--)
			list.add(inlist.get(st.get(i)));
		reslist.add(list);
	}

	public void dp(int tar, int usedp) {
		if (tar == 0) {
			genRes();
			return;
		}
		if (usedp < 0)
			return;
		// no res
		for (int i = usedp; i >= 0; i--) {
			int newtar = tar - inlist.get(i);
			if (newtar >= 0) {
				st.add(i);
				dp(newtar, i);
				st.remove(st.size() - 1);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		int lastv=-1;
		for(int i=0;i<candidates.length;i++){
			if(lastv!=candidates[i]){
				inlist.add(candidates[i]);
				lastv=candidates[i];
			}
		}
		dp(target, inlist.size() - 1);
		return reslist;
	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] n = new int[] { 1, 1, 2, 3, 4, 5 };
		System.out.println(cs.combinationSum(n, 10));
	}

}
