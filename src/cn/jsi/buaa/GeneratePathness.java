package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneratePathness {
	public static void main(String[] args) {
		GeneratePathness gp=new GeneratePathness();
		ArrayList<String> res=gp.generateParenthesis(4);
		for(String ts:res)
			System.out.println(ts);
	}
	int[][] ms = new int[2][];
	ArrayList<String> res = new ArrayList<String>();
	HashMap<String, Integer> traceMap = new HashMap<String, Integer>();

	public String getLR(int num, int lr) {
		String s = "";
		String basic = "(";
		if (lr == 1)
			basic = ")";
		for (int i = 0; i < num; i++)
			s += basic;
		return s;
	}

	public String getRes(boolean save) {
//		String ds="";
//		for (int i = 0; i < ms[0].length; i++) {
//			if(ms[0][i]==0)
//				continue;
//			ds+=ms[0][i]+"/"+ms[1][i]+", ";
//		}
//		System.out.println(ds);
		String s = "";
		for (int i = 0; i < ms[0].length; i++) {
			if(ms[0][i]==0)
				continue;
			s += getLR(ms[0][i], 0) + getLR(ms[1][i], 1);
		}
		if (save)
			res.add(s);
		return s;
	}

	public void dp(int n, int currentMax) {
		//System.out.println("dp  n="+n+"  currentMax="+currentMax);
		String key = getRes(false);
		Integer v = traceMap.get(key);
		if (v != null)
			return;
		traceMap.put(key, 1);
		if (n <= 0){
			getRes(true);
			return;
		}
		for (int i = 0; i <currentMax; i++) {
			ms[0][i]++;
			for (int j = i; j <currentMax; j++) {
				ms[1][j]++;
				dp(n - 1, currentMax);
				ms[1][j]--;
			}
			ms[0][i]--;
		}
		ms[0][currentMax] = 1;
		ms[1][currentMax] = 1;
		dp(n - 1, currentMax + 1);
		ms[0][currentMax] = 0;
		ms[1][currentMax] = 0;
	}

	public ArrayList<String> generateParenthesis(int n) {
		ms[0] = new int[n + 1];
		ms[1] = new int[n + 1];
		dp(n, 0);
		return res;
	}
}
