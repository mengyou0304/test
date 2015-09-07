package com.robin4.newc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-8-29.
 */
public class GraphValidTree {
    HashMap<Integer,Integer> outNumMap=new HashMap<Integer,Integer>();
    HashMap<Integer,HashSet<Integer>> fatherMap=new HashMap<Integer, HashSet<Integer>>();
    HashSet<Integer> singleFather=new HashSet<Integer>();

    public void addRelation(Integer son,Integer father){
        HashSet<Integer> set=fatherMap.get(son);
        if(set==null){
            set=new HashSet<Integer>();
            fatherMap.put(son,set);
        }
        if(set.contains(father))
            return;
        set.add(father);

        Integer sv=outNumMap.get(son);
        Integer fv=outNumMap.get(father);
        singleFather.add(father);
        if(sv==null)
            sv=0;
        if(fv==null)
            fv=0;
        outNumMap.put(son, sv);
        outNumMap.put(father, fv + 1);
    }

    public boolean validTree(int n, int[][] edges) {
        if(n!=edges.length+1)
            return false;
        if(n==1)
            return true;
        for(int k=0;k<edges.length;k++)
            addRelation(edges[k][1], edges[k][0]);

        for(int k=0;k<edges.length;k++)
            singleFather.remove(edges[k][1]);

        //>1 partition , <1 circle;
        if(singleFather.size()!=1)
            return false;

        //partition
        if(outNumMap.size()<n)
            return false;
        return true;

//        for(Integer v:allNodes){
//            if(pointedMap.get(v)==0){
//                startGoWith(v);
//                break;
//            }
//        }
//
//        //if no partition,all nodes should be removed
//        for(Integer v:allNodes){
//            //partition                //circle or partition
//            if(pointedMap.get(v)==null||pointedMap.get(v)!=0)
//                return false;
//        }
//        return true;
    }

    public void startGoWith(Integer co){
        if(outNumMap.get(co)==null||outNumMap.get(co)!=0)
            return;
        outNumMap.put(co,-1);
        HashSet<Integer> set=fatherMap.get(co);
        if(set==null)
            return;
        for(Integer father:set){
            Integer fv=outNumMap.get(father);
            if(fv==null)
                fv=0;
            outNumMap.put(father,fv-1);
            startGoWith(father);
        }
    }

    public static void main(String[] args) {
        GraphValidTree gt=new GraphValidTree();
        boolean res=gt.validTree(5,new int[][]{{0,1},{0,2},{1,2},{2,3},{2,4}});
        res=gt.validTree(1,new int[][]{});

        System.out.println("res="+res);
    }



}
