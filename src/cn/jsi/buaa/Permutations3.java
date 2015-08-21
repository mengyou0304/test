package cn.jsi.buaa;

import java.util.ArrayList;

public class Permutations3 {
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        ArrayList<ArrayList<Integer>> reslist=new ArrayList<ArrayList<Integer>>();
	        ArrayList<ArrayList<Integer>> reslist2=new ArrayList<ArrayList<Integer>>();
	        if(num.length==0)
	            return reslist;
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        list.add(num[0]);
	        reslist.add(list);
	        for(int k=1;k<num.length;k++){
	            for(int i=0;i<reslist.size();i++){
	                ArrayList<Integer> sq=reslist.get(i);
	                int len=sq.size();
	                for(int j=0;j<=len;j++)
	                    addRes(reslist2,sq,j,num[k]);
	            }
	            reslist.clear();
	            reslist=reslist2;
	            reslist2=new ArrayList<ArrayList<Integer>>();
	        }
	        return reslist;
	    }
	    public void addRes(ArrayList<ArrayList<Integer>> reslist2,ArrayList<Integer> sq,int j, int value){
	    	ArrayList<Integer> newlist=new ArrayList<Integer>();
	    	int i=0;
	    	for(;i<sq.size();i++){
	    		if(i==j){
	    			newlist.add(value);
	    		}
	    		newlist.add(sq.get(i));
	    	}
	    	if(i==j)
	    		newlist.add(value);
	    	reslist2.add(newlist);
	        
	    }
	    public static void main(String[] args) {
	    	Permutations3 s3=new Permutations3();
	    	ArrayList<ArrayList<Integer>> list=s3.permute(new int[]{1,2,3,4});
	    	System.out.println(list);
	    	System.out.println(list.size());
		}

}
