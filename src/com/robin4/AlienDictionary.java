package com.robin4;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by robinmac on 15-8-31.
 */
public class AlienDictionary {
    //st1->end
    //st2->end
    //save as: end->(st1,st2,st3)
    HashMap<Character, HashSet<Character>> endToStarter = new HashMap<Character, HashSet<Character>>();

    //end->a1
    //end->a2
    //save as: end->(2)
    HashMap<Character, Integer> outerNums = new HashMap<Character, Integer>();

    String res = "";
    boolean fault=false;

    private void treatAsEnd(Character zc) {
        if(fault)
            return;
//        System.out.println("Treat As End " + zc );
        HashSet<Character> set = endToStarter.get(zc);
        Integer num=outerNums.get(zc);
        if(num==null||num!=0)
            return;
        outerNums.remove(zc);
        res = zc + res;
//        System.out.println("set is: " + set);
        Character onlyzc = null;
        for (Character father : set) {
            Integer v = outerNums.get(father);
            if (v > 0) {
                outerNums.put(father, v - 1);
                v--;
            }
            if (v ==0) {
                if (onlyzc != null) {
                    fault=true;
                }
                onlyzc = father;

                treatAsEnd(father);
            }
        }
        if (onlyzc == null&&outerNums.size()!=0) {
//            System.out.println(outerNums);
            fault=true;
        }
    }

    private void addRelation(Character small, Character big) {
        //outer
        Integer i = outerNums.get(big);
        if (i == null)
            i = 0;
        outerNums.put(big, i + 1);
        i = outerNums.get(small);
        if (i == null) {
            outerNums.put(small,0);
        }

        //end to start
        HashSet<Character> tset = endToStarter.get(small);
        if (tset == null) {
            tset = new HashSet<Character>();
            endToStarter.put(small, tset);
        }
        tset.add(big);
        tset = endToStarter.get(big);
        if (tset == null) {
            tset = new HashSet<Character>();
            endToStarter.put(big, tset);
        }
    }

    public String alienOrder(String[] words) {
        char[][] ws = new char[words.length][];
        for (int i = 0; i < words.length; i++)
            ws[i] = words[i].toCharArray();
        for (int i = 0; i < ws.length - 1; i++) {
            for (int j = 0; j < ws[i].length; j++) {
                if (j >= ws[i + 1].length)
                    break;
                if (ws[i][j] != ws[i + 1][j]) {
                    addRelation(ws[i][j], ws[i + 1][j]);
                    break;
                }
            }
        }
//        System.out.println("adding relations finish");
//        System.out.println(endToStarter);
//        System.out.println(outerNums+"\n\n\n\n");
        for (Character c : endToStarter.keySet()) {
            treatAsEnd(c);
        }
        if(fault)
            return "";
        return res;
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        AlienDictionary ad = new AlienDictionary();
        String res = ad.alienOrder(ss);
//        System.out.println("res="+res);

    }


}
