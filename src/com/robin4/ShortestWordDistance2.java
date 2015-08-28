package com.robin4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by robinmac on 15-8-27.
 */
public class ShortestWordDistance2 {

    public ShortestWordDistance2() {
        String[] words = new String[]{"a", "b", "c", "word1", "word2", "word3", "word4","b","a"};
        WordDistance(words);
        int v1 = shortest("word1", "word2");
        int v2 = shortest("a", "word4");
        System.out.println(v1 + " " + v2);
    }

    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    public void WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> list = map.get(words[i]);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(words[i], list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        if (l1 == null || l2 == null)
            return -1;
        int mindis = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            int v2 = l2.get(p2);
            int v1 = l1.get(p1);
            mindis = Math.min(mindis, Math.abs(v1 - v2));
            if(v1<v2)
                p1++;
            if(v2<v1)
                p2++;
        }
        return mindis;
    }

    public static void main(String[] args) {
        ShortestWordDistance2 m = new ShortestWordDistance2();

    }
}
