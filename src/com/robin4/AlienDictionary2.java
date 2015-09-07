package com.robin4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-8-31.
 */
public class AlienDictionary2 {

    HashMap<Character, Integer> outPoints = new HashMap<Character, Integer>();

    HashMap<Character, HashSet<Character>> fatherMap = new HashMap<Character, HashSet<Character>>();

    HashSet<Character> wordset=new HashSet<Character>();

    String res = "";

    public String alienOrder(String[] words) {
        char[][] cs = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            cs[i] = words[i].toCharArray();
            for(char tc:cs[i])
                wordset.add(tc);
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int d = 0; d < cs[i].length && d < cs[i + 1].length; d++)
                if (cs[i][d] != cs[i + 1][d]) {
                    addConnection(cs[i][d], cs[i + 1][d]);
                    break;
                }
        }
        //
        for (Character c : outPoints.keySet()) {
            startFrom(c);
        }

        //some point havent go through: Partitioned
        //also my lead by circle which can't find any point
        if (fatherMap.size() > 0)
            return "";
        //partition
        if(cs.length==2&&cs[0].length==1&&cs[1].length==1&&cs[0][0]==cs[1][0])
            return ""+cs[0][0];

        if(wordset.size()>0)
            return "";
        return res;
    }

    private void startFrom(Character c) {
        Integer v = outPoints.get(c);
        HashSet<Character> set = fatherMap.get(c);
        if (v == null || v != 0)
            return;
        //no outer, should be end

        fatherMap.remove(c);
        wordset.remove(c);
        res =  res+c;
        if (set == null)
            return;
        for (Character father : set) {
            Integer fv = outPoints.get(father);
            if (fv >= 1)
                outPoints.put(father, fv - 1);
            if (fv == 1) {
                startFrom(father);
                outPoints.put(father,  - 1);
            }
        }

    }


    private void addConnection(char small, char big) {
//        System.out.println(big+"->"+small);
        //add outerPoints for big
        Integer v = outPoints.get(big);
        if (v == null)
            v = 0;
        outPoints.put(big, v + 1);
        v = outPoints.get(small);
        if (v == null)
            v = 0;
        outPoints.put(small, v);
        // add fathers for small
        HashSet<Character> set = fatherMap.get(small);
        if (set == null) {
            set = new HashSet<Character>();
            fatherMap.put(small, set);
        }
        set.add(big);
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        ss = new String[]{
                "wrt", "wrf", "er", "ett", "rftt"
        };
        ss=new String[]{"z","z"};
        AlienDictionary2 ad = new AlienDictionary2();
        String res = ad.alienOrder(ss);
        System.out.println("res=" + res);

    }


}
