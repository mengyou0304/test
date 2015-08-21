package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetS2 {
	 ArrayList<ArrayList<Integer>> reslist=new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> slist=new ArrayList<Integer>();
	    int[] s;
	    public void dp(int p){
	        if(p>=s.length){
	            genRes();
	            return;
	        }
	        dp(p+1);
	        slist.add(s[p]);
	        dp(p+1);
	        slist.remove(slist.size()-1);
	    }
	    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
	        Arrays.sort(S);
	        s=S;
	        dp(0);
	        return reslist;
	        
	    }
	    public void genRes(){
	        ArrayList<Integer> tlist=new  ArrayList<Integer> ();
	        for(int i:slist)
	            tlist.add(i);
	        reslist.add(tlist);
	    }
	    public static void main(String[] args) {
	    	SubSetS2 s2=new SubSetS2();
	    	ArrayList<ArrayList<Integer>> reslist=s2.subsets(new int[]{0,1,2});
	    	System.out.println(reslist);
		}

}
