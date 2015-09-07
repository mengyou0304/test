package com.robin4.newc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-9-1.
 */
public class CourseSchedule {

    HashMap<Integer,Integer> outNumMap=new HashMap<Integer,Integer>();
    HashMap<Integer,HashSet<Integer>> fatherMap=new HashMap<Integer, HashSet<Integer>>();
    HashSet<Integer> courses=new HashSet<Integer>();

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
        if(sv==null)
            sv=0;
        if(fv==null)
            fv=0;
        outNumMap.put(son, sv);
        outNumMap.put(father, fv + 1);


    }

    // only problem is circle
    public boolean canFinish(int numCourses, int[][] rel) {
        for(int i=0;i<rel.length;i++)
            addRelation(rel[i][0],rel[i][1]);
        for(int i=0;i<numCourses;i++)
            courses.add(i);
//        System.out.println("Before!!");
//        System.out.println("sonMap:"+sonMap);
//        System.out.println("OuterMap:"+pointedMap);
        for(Integer co:courses) {
            startGoWith(co);
        }
//        System.out.println("After!!");
//        System.out.println("sonMap"+sonMap);
//        System.out.println("OuterMap:"+pointedMap);
        for(Integer key:outNumMap.keySet()){
            if(outNumMap.get(key)>0)
                return false;
        }
        return true;
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
        CourseSchedule cs=new CourseSchedule();
        boolean res=cs.canFinish(8,new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}});
        System.out.println(res);
    }
}
