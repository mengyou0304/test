package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Permutations2 {
	HashMap<Integer, Integer> vmap = new HashMap<Integer, Integer>();
	ArrayList<ArrayList<Integer>> reslist = new ArrayList<ArrayList<Integer>>();
	int[] n;
	public void genRes(ArrayList<Integer> res){
	    ArrayList<Integer> tlist=new ArrayList<Integer>();
	    for(Integer m:res)
	        tlist.add(m);
	    reslist.add(tlist);
	}
    //level presents the level-th obj in res should be determined;
    //step presents where the level should start to avoid duplication;
	public void dp(int level, ArrayList<Integer> res) {
	    if(level==n.length)
	        genRes(res);
	    int li=Integer.MAX_VALUE;
		for (int i = 0; i < n.length; i++) {
		    if(n[i]==li)
		        continue;
		    li=n[i];
		    Integer m=vmap.get(li);
		    if(m<=0)
		        continue;
		    vmap.put(li,m-1);
		    res.add(li);
		    dp(level+1,res);
		    res.remove(res.size()-1);
		    vmap.put(li, m);
		}
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		n = num;
		for (Integer m : num) {
			Integer i = vmap.get(m);
			if (i == null)
				i = new Integer(0);
			vmap.put(m, i + 1);
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		dp(0, res);
		return reslist;
	}

	public static void main(String[] args) {
		
		Permutations2 p=new Permutations2();
		System.out.println(p.permuteUnique(new int[]{-1,2,2,-1,1,1,-1}));
	}

}
