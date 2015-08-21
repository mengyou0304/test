package com.robin3;

public class GenerateParrentnessNum {
	int[][] dps;
	public int getGPNum(int n){
		dps=new int[n+5][n+5];
		return dp(n,0,0);
	}
	public int dp(int n,int left,int p){
		if(dps[left][p]!=0)
			return dps[left][p];
		int res=0;
		if(p==n-1){
			return 1;
		}
		left++;
		for(int i=0;i<=left;i++)
			res+=dp(n,left-i,p+1);
		dps[left][p]=res;
		return res;
	}
	public static void main(String[] args) {
		GenerateParrentnessNum gpn=new GenerateParrentnessNum();
		System.out.println(gpn.getGPNum(1));
		System.out.println(gpn.getGPNum(2));
		//System.out.println(gpn.getGPNum(300));
		
	}

}
