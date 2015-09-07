package com.robin4.newc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-8-29.
 */
public class GraphValidTree2 {
    boolean debug=false;
    HashMap<Integer,HashSet<Integer>> connectionMap=new HashMap<Integer,HashSet<Integer>>();
    //联通 无环
    public boolean validTree(int n, int[][] edges) {
        int len=edges.length;
        if(len!=n-1)
            return false;
        if(n<2&&n>-1)
            return true;
        // add connections
        for(int i=0;i<len;i++) {
            int n1=edges[i][0];
            int n2=edges[i][1];
            HashSet<Integer> s1=connectionMap.get(n1);
            HashSet<Integer> s2=connectionMap.get(n2);
            if(s1==null) {
                s1 = new HashSet<Integer>();
                connectionMap.put(n1,s1);
            }
            if(s2==null) {
                s2 = new HashSet<Integer>();
                connectionMap.put(n2,s2);
            }
            s1.add(n2);
            s2.add(n1);
        }
        if(debug)
            System.out.println(connectionMap);
        //start travel from random node
        Integer startNode=connectionMap.keySet().iterator().next();
        ArrayList<Integer> nlist1=new ArrayList<Integer>();
        ArrayList<Integer> nlist2=new ArrayList<Integer>();
        nlist1.add(startNode);
        HashSet<Integer> travelSet=new HashSet<Integer>();
        travelSet.add(startNode);
        // bfs be attention of circle
        while(nlist1.size()>0){
            if(debug)
                System.out.println(nlist1);
            for(Integer i:nlist1){
                for(Integer node:connectionMap.get(i)) {
                    if(node==i)
                        continue;
                    //circle
                    if (travelSet.contains(node))
                        return false;
                    nlist2.add(node);
                    connectionMap.get(node).remove(i);
                }
            }
            travelSet.addAll(nlist2);
            nlist1.clear();
            nlist1=nlist2;
            nlist2=new ArrayList<Integer>();
        }
        if(debug)
            System.out.println("travelSet:"+travelSet);
        //partition
        if(travelSet.size()!=connectionMap.keySet().size()||connectionMap.size()!=n)
            return false;
        return true;
    }


    public static void main(String[] args) {
        GraphValidTree2 gt=new GraphValidTree2();
//        boolean res=gt.validTree(5,new int[][]{{0,1},{0,2},{1,2},{2,3},{2,4}});
        boolean res=gt.validTree(5,new int[][]{{0,1},{0,2},{2,3},{2,4}});
        System.out.println("res="+res);
    }



}
