package cn.jsi.buaa;

import java.util.Stack;

public class ContainnerWithMostWater {
	public int computStack(Stack<Integer> st, int waterlevel) {
		int waterpoll = 0;
		while (st.size() > 0) {
			int v = st.pop();
			waterpoll += waterlevel - v;
		}
		return waterpoll;
	}

	public int maxArea(int[] height) {
		int maxp = 0;
		int lastlevel = 0;
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			if (height[i] >= lastlevel) {
				int water = computStack(st, lastlevel);
				if (maxp < water)
					maxp = water;
				lastlevel = height[i];
			} else
				st.add(height[i]);
		}
		lastlevel = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] >= lastlevel) {
				int water = computStack(st, lastlevel);
				if (maxp < water)
					maxp = water;
				lastlevel = height[i];
			} else
				st.add(height[i]);
		}
		return maxp;
	}
	public static void main(String[] args) {
		ContainnerWithMostWater w=new ContainnerWithMostWater();
		//int a1=w.maxArea(new int[]{1,2,3,4,5,6,7,6,5,4,4,3,1});
		int a1=w.maxArea(new int[]{3,2,1,2,3,4});
		System.out.println(a1);
	}
}
