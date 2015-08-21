package cn.jsi.buaa;

import java.util.ArrayList;

public class GrayCode {
	int[] base = new int[4];
	ArrayList<Integer> reslist = new ArrayList<Integer>();

	public void multiple(int k) {
		int n = reslist.size();
		for (int i = n-1; i >=0; i--) {
			reslist.add(reslist.get(i) + (1 << k));
		}
	}

	public ArrayList<Integer> grayCode(int n) {
		reslist.add(0);
		reslist.add(1);
		for (int i = 2; i <= n; i++) {
			multiple(i-1);
		}
		return reslist;
	}
	public static void main(String[] args) {
		GrayCode gc=new GrayCode();
		System.out.println(gc.grayCode(4));
	}

}
