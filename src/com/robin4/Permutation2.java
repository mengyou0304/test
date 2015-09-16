package com.robin4;

import java.util.*;

/**
 * Created by robinmac on 15-9-7.
 */
public class Permutation2 {

    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

    List<List<Integer>> reslist=new ArrayList<List<Integer>>();
    int[] tnums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        tnums=new int[nums.length];
        for(int i:nums){
            Integer v=map.get(i);
            if(v==null)
                v=0;
            map.put(i,v+1);
        }
        Iterator<Integer> keys=map.keySet().iterator();
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(keys.hasNext())
            list.add(keys.next());
        Collections.sort(list);
        goWith(list,0,nums.length);
        return reslist;
    }

    private void goWith(ArrayList<Integer> list, int i, int length) {
        if(i==length){
            ArrayList<Integer> tlist=new ArrayList<Integer>();
            for(int v:tnums)
                tlist.add(v);
            reslist.add(tlist);
            return;
        }
        for(Integer v:list) {
            if(map.get(v)==0)
                continue;
            tnums[i] = v;
            map.put(v,map.get(v)-1);
            goWith(list, i + 1, length);
            map.put(v, map.get(v) + 1);
        }
    }

    public static void main(String[] args) {
        Permutation2 p2=new Permutation2();
        System.out.println(p2.permuteUnique(new int[]{2, 2, 1}));
    }

    //////////////////////////////////////////////////////////////////////

    public String getPermutation(int n, int k) {
        return "";
    }

    //////////////////////////////////////////////////////////////////////


}
