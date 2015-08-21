package cn.jsi.buaa;

import java.util.ArrayList;

public class PermutationSeq {
	public String getPermutation(int n, int k) {
		k--;
        int[] l=new int[n+1];
        ArrayList<Integer> reslist=new ArrayList<Integer>();
        l[0]=1;
        for(int i=1;i<=n;i++){
            l[i]=l[i-1]*i;
            reslist.add(i);
        }
        String s="";
        for(int i=n-1;i>=0;i--){
            int m=k/l[i];
            k=k-m*l[i];
            s+=reslist.get(m);
            reslist.remove(m);
        }
        return s;
    }
	public static void main(String[] args) {
		PermutationSeq ps=new PermutationSeq();
		String s=ps.getPermutation(4, 15);
		System.out.println(s);
	}

}
