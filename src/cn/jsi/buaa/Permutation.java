package cn.jsi.buaa;

import java.util.*;

public class Permutation {
	
	
	public static void main(String[] args) {
		Permutation p=new Permutation();
		ArrayList<ArrayList<Integer>> list=p.permute(new int[]{1,2,3});
		 for(ArrayList<Integer> li:list){
			  for(Integer i:li)
				  System.out.print(i+" " );
			  System.out.println();
		  }
	}
	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    HashMap<Integer,Integer> indexMap=new HashMap<Integer,Integer>();
    int n;
    int nums[];
    boolean used[];
    int [] tres;
    public void genRes(){
         ArrayList<Integer> tlist=new  ArrayList<Integer>();
         for(Integer i:tres)
             tlist.add(i);
         res.add(tlist);
       
    }
    public void dp(int level){
        if(level>=n){
            genRes();
            return;
        }
        for(int i=0;i<n;i++){
        	if(used[i])
        		continue;
            tres[level]=nums[i];
            used[i]=true;
            dp(level+1);
            used[i]=false;
        }
    }
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        nums=num;
        n=nums.length;
        tres=new int[n];
        used=new boolean[n];
        for(int i=0;i<n;i++){
            indexMap.put(num[i],i);
            used[i]=false;
        }
        dp(0);
        return res;
    }
}
