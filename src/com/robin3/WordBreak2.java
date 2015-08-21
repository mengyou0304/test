package com.robin3;

import java.util.ArrayList;
import java.util.Set;

public class WordBreak2 {
    Set<String> dict;
    ArrayList<String> reslist=new ArrayList<String>();
    ArrayList<ArrayList<String>> recordlist;
    int[] arrive;
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        this.dict=dict;
        arrive=new int[s.length()+10];
        recordlist=new ArrayList<ArrayList<String>>(s.length()+10);
        dp(0,s);
        return reslist;
    }
    public ArrayList<String> dp(int clen,String cline){
        if(recordlist.get(clen)!=null)
            return recordlist.get(clen);
        ArrayList<String> reslist=new ArrayList<String>();
        for(String word:dict){
            if(cline.startsWith(word)){
                String nline=cline.substring(word.length());
                ArrayList<String> oldres=dp(clen+word.length(),nline);
                for(String s:oldres)
                    reslist.add(word+" "+s);
            }
        }
        recordlist.set(clen,reslist);
        return reslist;
    }

}
