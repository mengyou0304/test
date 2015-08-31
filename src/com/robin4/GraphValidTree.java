package com.robin4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-8-29.
 */
public class GraphValidTree {
    boolean haveCircle=false;
    boolean leftNode=false;
    HashSet<Integer> goThroughSet=new HashSet<Integer>();
    HashSet<Integer> edgeSet=new HashSet<Integer>();

    HashMap<Integer,HashSet<Integer>> map=new HashMap<Integer,HashSet<Integer>>();
    public boolean validTree(int n, int[][] edges) {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == 1) {
                    edgeSet.add(i);
                    edgeSet.add(j);
                    HashSet<Integer> s1 = map.get(i);
                    HashSet<Integer> s2 = map.get(j);
                    if (s1 == null) {
                        s1 = new HashSet<Integer>();
                        map.put(i, s1);
                    }
                    if (s2 == null) {
                        s2 = new HashSet<Integer>();
                        map.put(j, s2);
                    }
                    s1.add(j);
                    s2.add(i);
                }
            }
        }
        haveCircle=dfs(0, new HashSet<Integer>());
        if (goThroughSet.size()<edgeSet.size())
            leftNode=true;
        if(haveCircle||leftNode)
            return false;
        return true;
    }

    //return haveCircle?
    private boolean dfs(int i, HashSet<Integer> connectionSet) {
        HashSet<Integer> set=map.get(i);
        for(Integer v:set){
            goThroughSet.add(v);
            if(connectionSet.contains(v))
                return false;
            connectionSet.add(v);
            dfs(v,connectionSet);
            connectionSet.remove(v);
        }
        return true;
    }
}
