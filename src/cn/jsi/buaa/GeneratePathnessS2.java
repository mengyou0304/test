package cn.jsi.buaa;

import java.util.ArrayList;

public class GeneratePathnessS2 {
	public static void main(String[] args) {
		GeneratePathnessS2 gp=new GeneratePathnessS2();
		ArrayList<String> res=gp.generateParenthesis(3);
		for(String ts:res)
			System.out.println(ts);
	}

	ArrayList<String> res=new ArrayList<String>();
	int n;
	public void dp(String s, int l,int r){
		if(l==n){
//			for(int i=0;i<l-r;i++)
//				s+=")";
			res.add(s);
			return;
		}
		dp(s+"(",l+1,r);
		if(l>r)
			dp(s+")",l,r+1);
	}
	public ArrayList<String> generateParenthesis(int N) {
		n=N;
		dp("",0,0);
		return res;
	}
}
