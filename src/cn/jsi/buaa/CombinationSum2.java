package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
	ArrayList<ArrayList<Integer>> reslist = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> st = new ArrayList<Integer>();
	int[] n;
	int[] sum;

	public void genRes() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=st.size()-1;i>=0;i--)
			list.add(st.get(i));
		reslist.add(list);
	}

	public void dp(int tar, int usedp) {
		if (tar == 0) {
			genRes();
			return;
		}
		if (usedp < 0||tar>sum[usedp])
			return;
		// no res
		int lastused = -1;
		for (int i = usedp; i >= 0; i--) {
			if (lastused == n[i])
				continue;
			int newtar = tar - n[i];
			if (newtar >= 0) {
				lastused = n[i];
				st.add(n[i]);
				dp(newtar, i - 1);
				st.remove(st.size() - 1);
			}

		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		n = candidates;
		System.out.println(n);
		sum = new int[n.length];
		sum[0] = n[0];
		for (int i = 1; i < n.length; i++)
			sum[i] = sum[i - 1] + n[i];
		dp(target, n.length - 1);
		return reslist;
	}
	public static void main(String[] args) {
		CombinationSum2 cs = new CombinationSum2();
		int[] n = new int[] { 5,4,3, 2, 3, 1,1};
		System.out.println(cs.combinationSum2(n, 10));
	}

}
