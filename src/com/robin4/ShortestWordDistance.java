package com.robin4;

/**
 * Created by robinmac on 15-8-27.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int s1=-1;
        int s2=-1;
        int mindis=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            String st=words[i];
            if(st==null)
                continue;
            if(st.equals(word1))
                s1=i;
            if(st.equals(word2))
                s2=i;
            if(s1!=-1&&s2!=-1)
                mindis=Math.min(mindis,Math.abs(s1-s2));
        }
        if(mindis==Integer.MAX_VALUE)
            mindis=-1;
        return mindis;
    }
}
