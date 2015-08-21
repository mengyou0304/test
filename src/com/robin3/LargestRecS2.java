package com.robin3;

import java.util.Arrays;
import java.util.Stack;

public class LargestRecS2 {
	public int largestRectangleArea(int[] h) {
		if(h.length==0)
				return 0;
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> indexst = new Stack<Integer>();
		int cmax = 0;
		h = Arrays.copyOf(h, h.length + 1);
		int lastv = -1;
		for (int i = 0; i < h.length; i++) {
			int v = h[i];
			if (v <= lastv) {
				int oldv = st.peek();
				int oldIndex = indexst.peek();
				int thisindex=i;
				while (oldv > v) {
					oldv = st.pop();
					oldIndex = indexst.pop();
					thisindex=oldIndex;
					cmax = Math.max(cmax, oldv * (i - oldIndex));
					if(st.size()==0)
						break;
					oldv = st.peek();
					oldIndex = indexst.peek();
				}
				st.push(v);
				indexst.push(thisindex);
			}else{
		    		st.push(v);
			    indexst.push(i);
			}
			lastv = v;
		}
		return cmax;
	}
	public static void main(String[] args) {
		LargestRecS2 lr=new LargestRecS2();
		int v=lr.largestRectangleArea(new int[]{0,});
		System.out.println(v);
	}

}
