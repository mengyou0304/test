package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;

public class LargestRec {
	ArrayList<Integer> maxlist = new ArrayList<Integer>();
	Integer[] num = new Integer[999999];
	Integer[] ar = new Integer[999999];
	int pointer = 0;
	int tempmax = 0;
	int tmpr = 0;
	int backs = -1;

	public void debugP() {
		System.out.println("==============");
		for (int i = 0; i <= 10; i++)
			System.out.print(ar[i] + " ");
		System.out.println();
		for (int i = 0; i <= 10; i++)
			System.out.print(num[i] + " ");
		System.out.println("");
	}

	public int m1(Integer[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		ar[pointer] = height[0];
		num[pointer] = 0;
		debugP();
		for (int i = 1; i < len; i++) {
			// ai>ai-1
			if (height[i] >= height[i - 1]) {
				pointer++;
				ar[pointer] = height[i];
				num[pointer] = i;
			}
			// ai<ai-1
			if (height[i] < height[i - 1]) {
				while (pointer >= 0) {
					if (ar[pointer] > height[i]) {
						tmpr = ar[pointer] * (i - num[pointer]);
						if (tmpr > tempmax)
							tempmax = tmpr;
						backs = num[pointer];
						pointer--;
					} else
						break;

				}
				pointer++;
				ar[pointer] = height[i];
				num[pointer] = backs;
			}
			// System.out.println(i+" "+ height[i]+"  "+tempmax);
			// debugP();
		}
		while (pointer >= 0) {
			tmpr = ar[pointer] * (len - num[pointer]);
			if (tmpr > tempmax)
				tempmax = tmpr;
			pointer--;

		}
		return tempmax;
	}

	public void add() {

	}

	public void pop() {

	}

	public int m2(Integer[] h) {
		Stack<Integer> values = new Stack<Integer>();
		Stack<Integer> numbers = new Stack<Integer>();
		int maxv = -1;
		int tmpv = -1;
		int tmpi = 0;
		int backs=-1;
		int len = h.length;
		
		for (int i = 0; i < len; i++) {
			if (values.isEmpty()||h[i] > values.peek()){
				values.push(h[i]);
				numbers.push(i);
			}
			if (h[i] < values.peek()) {
				while (!values.isEmpty()) {
				
					if (values.peek() > h[i]) {
						tmpv=values.pop();
						tmpi=numbers.pop();
						tmpv =tmpv * (i - tmpi);
						if (maxv < tmpv)
							maxv = tmpv;
					}else break;
				}
				values.push(h[i]);
				numbers.push(tmpi);
			}
		}
		while (!values.isEmpty()) {
				tmpv=values.pop();
				tmpi=numbers.pop();
				tmpv =tmpv * (len - tmpi);
				if (maxv < tmpv)
					maxv = tmpv;
		}
		return maxv;
	}

	public int largestRectangleArea(Integer[] height) {
		return m2(height);
	}

	public static void main(String[] args) {
		LargestRec l = new LargestRec();
		Integer[] data = getTestData();
		int v = l.largestRectangleArea(data);
		System.out.println("v=" + v);

	}

	private static Integer[] getTestData() {
		Integer[] data = new Integer[] {4,3,5,5,9,2,8,4,7,2,3,8,3,5,4,7,9 };
		return data;
	}

}
