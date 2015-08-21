package com.robin3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {
	HashSet<Integer> used=new HashSet<Integer>();
    ArrayList<List<Integer>> reslist=new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] num) {
        dp(0,num,new ArrayList<Integer>());
        return reslist;
    }
    public void dp(int p,int[] num,ArrayList<Integer> list){
        if(p>=num.length){
            ArrayList<Integer> tlist=new ArrayList<Integer>();
            for(Integer i:list)
                tlist.add(i);
            reslist.add(tlist);
            return;
        }
        for(int i=0;i<num.length;i++){
            if(!used.contains(num[i])){
                list.add(num[i]);
                used.add(num[i]);
                dp(p+1,num,list);
                used.remove(num[i]);
                list.remove(list.size()-1);
            }
        }
    }
}
