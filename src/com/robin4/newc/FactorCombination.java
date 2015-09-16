package com.robin4.newc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by robinmac on 15-9-10.
 */
public class FactorCombination {


    HashMap<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res=getFactors2(n);
        if(res.size()>0)
            res.remove(res.size()-1);
        return res;
    }
    public List<List<Integer>> getFactors2(int n) {
        if (map.get(n) != null)
            return map.get(n);
        ArrayList<List<Integer>> reslist = new ArrayList<List<Integer>>();
        for (int i = n / 2; i > 1; i--) {
            if (n % i == 0 ) {
                List<List<Integer>> sonList = getFactors2(n / i);
                for (List<Integer> tlist : sonList) {
                    if(tlist.size()==0)
                        continue;
                    if(i<tlist.get(tlist.size()-1))
                        continue;
                    ArrayList<Integer> copylist = new ArrayList<Integer>();
                    for (Integer v : tlist)
                        copylist.add(v);
                    copylist.add(i);
                    reslist.add(copylist);
                }
            }
        }
        ArrayList<Integer> copylist = new ArrayList<Integer>();
        copylist.add(n);
        reslist.add(copylist);
        map.put(n, reslist);
        return reslist;
    }

    public static void main(String[] args) {
        FactorCombination fc = new FactorCombination();
        System.out.println(fc.getFactors2(32));
    }
}
