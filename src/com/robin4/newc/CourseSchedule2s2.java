package com.robin4.newc;

import cn.jsi.buaa.basic.DataGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-9-1.
 */
public class CourseSchedule2s2 {

    HashMap<Integer, Integer> pointedMap = new HashMap<Integer, Integer>();
    HashMap<Integer, HashSet<Integer>> sonMap = new HashMap<Integer, HashSet<Integer>>();
    HashSet<Integer> nodeSet = new HashSet<Integer>();

    public void addRelation(Integer son, Integer father) {
        nodeSet.add(son);
        nodeSet.add(father);
        HashSet<Integer> set = sonMap.get(father);
        if (set == null) {
            set = new HashSet<Integer>();
            sonMap.put(father, set);
        }
        if (set.contains(son))
            return;
        set.add(son);

//        System.out.println("adding connection: "+father+"->"+son);

        Integer sv = pointedMap.get(son);
        Integer fv = pointedMap.get(father);
        if (sv == null)
            sv = 0;
        if (fv == null)
            fv = 0;
        pointedMap.put(son, sv + 1);
        pointedMap.put(father, fv);
    }

    ArrayList<Integer> reslist = new ArrayList<Integer>();

    public int[] findOrder(int numCourses, int[][] rel) {
        for (int i = 0; i < rel.length; i++)
            addRelation(rel[i][0], rel[i][1]);

        for (Integer i : nodeSet) {
            startGoWith(i);
        }
        for (Integer key : pointedMap.keySet()) {
            if (pointedMap.get(key) > 0)
                return new int[]{};
        }
        int[] resarray = new int[reslist.size()];
        for (int i = 0; i < resarray.length; i++)
            resarray[i] = reslist.get(i);
        return resarray;
    }


    public void startGoWith(Integer co) {
        if (pointedMap.get(co) == null) {
            reslist.add(co);
            pointedMap.put(co, -1);
            return;
        }
        if (pointedMap.get(co) != 0)
            return;
        pointedMap.put(co, -1);
        reslist.add(co);
        HashSet<Integer> set = sonMap.get(co);
        if (set == null)
            return;
        for (Integer son : set) {
            Integer fv = pointedMap.get(son);
            pointedMap.put(son, fv - 1);
            startGoWith(son);
        }
    }

    public static void main(String[] args) {
        CourseSchedule2s2 cs = new CourseSchedule2s2();
        int[] res = cs.findOrder(8, new int[][]{{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}});
        DataGen.showArray(res);
    }
}
