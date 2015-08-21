package com.robin3;

import java.util.Arrays;
import java.util.Stack;

public class LargestRec {
	public int largestRectangleArea(int[] h) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> indexst = new Stack<Integer>();
		int cmax = 0;
		h = Arrays.copyOf(h, h.length + 1);
		int lastv = 0;
		for (int i = 0; i < h.length; i++) {
			int v = h[i];
			if (v > lastv) {
				st.push(v);
				indexst.push(i);
			} else {
				int oldv = st.peek();
				int oldIndex = indexst.peek();
				while (oldv > v) {
					oldv = st.pop();
					oldIndex = indexst.pop();
					cmax = Math.max(cmax, oldv * (i - oldIndex));
					if(st.size()==0)
						break;
					oldv = st.peek();
					oldIndex = indexst.peek();
				}
			}
			lastv = v;
		}
		return cmax;
	}

	public static void main(String[] args) {
		LargestRec lr = new LargestRec();
		int v=lr.largestRectangleArea(new int[]{1,2,3,4,5,4,3,2,1});
		System.out.println(v);

	}

}
