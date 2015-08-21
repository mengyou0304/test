package cn.jsi.buaa;

import java.util.Arrays;

public class Sum3closed {
	int[] n;
	int tmpsum;
	public int solve(int sindex,int value){
		int minvalue=Integer.MAX_VALUE;
		int start=sindex+1;
		int end=n.length-1;
		int tmpv;
		while(start<end){
			tmpv=value-(n[start]+n[end]);
			if(minvalue>Math.abs(tmpv)){
				minvalue=Math.abs(tmpv);
				tmpsum=n[start]+n[end];
			}
			if(tmpv==0){
				return 0;
			}
			if(tmpv<0){
				end--;
			}else
				start++;
		}
		return minvalue;
	}
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		n=num;
		int min=Integer.MAX_VALUE;
		int relatedSum=0;
		for(int i=0;i<n.length-2;i++){
			int tmp=solve(i,target-n[i]);
			if(min>tmp){
				min=tmp;
				relatedSum=n[i]+tmpsum;
			}
		}
		return relatedSum;
	}
	public static void main(String[] args) {
		Sum3closed sc=new Sum3closed();
		int[] in=new int[]{-1, 2, 1, -4};
		int v=sc.threeSumClosest(in, 1);
		System.out.println(v);
	}

}
