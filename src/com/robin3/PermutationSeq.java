package com.robin3;

import java.util.LinkedList;

public class PermutationSeq {
	public String getPermutation(int n, int k) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        int[] nums=new int[11];
        for(int i=0;i<11;i++){
        		if(i==0)
        			nums[i]=1;
        		else
        			nums[i]=nums[i-1]*i;
            list.add(i);
        }
        int v=0;
        int cn=n;
        String res="";
        k--;
        while(cn>=1){
        		v=k/nums[cn-1];
        		System.out.print("v="+k+"/"+nums[cn-1]+" ");
            k=k-v*(nums[cn-1]);
            System.out.println(" k="+k);
            res+=list.get(v+1);
            list.remove(v+1);
            cn--;
        }
        return res;
    }
	public static void main(String[] args) {
		PermutationSeq ps=new PermutationSeq();
		String res=ps.getPermutation(4, 13);
		System.out.println(res);
	}

}
