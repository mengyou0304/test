package com.robin4;

import java.util.*;

/**
 * Created by robinmac on 15-8-25.
 */
public class WordBreak2S2 {
    ArrayList<String> reslist=new ArrayList<String>();
    HashMap<Integer,ArrayList<String>> rec;
    Set<String> dict;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        rec=new HashMap<Integer,ArrayList<String>>();
        dict=wordDict;
        ArrayList<String> list=new ArrayList<String>();
        list.add("");
        rec.put(s.length(), list);
        ArrayList<String> res=dp(s,0);
        ArrayList<String> nres=new ArrayList<String>();
        for(String ts:res)
            nres.add(ts.trim());
        return nres;

    }
    /**
     * stlen: started char
     */
    public ArrayList<String> dp(String ns,int stlen){
        if(rec.get(stlen)!=null) {
            return rec.get(stlen);
        }
        System.out.println("calling "+ns+" len="+stlen);
        ArrayList<String> nlist=new ArrayList<String>();
        for(String s:dict){
            if(ns.startsWith(s)){
                ArrayList<String> afterList=dp(ns.substring(s.length(),ns.length()),stlen+s.length());
                for(String ts:afterList)
                    nlist.add(s+" "+ts);
            }
        }
        rec.put(stlen, nlist);
        return nlist;
    }
    public static void testWith(String ss,HashSet<String> set){
        WordBreak2S2 wb=new WordBreak2S2();
        List<String> list=wb.wordBreak(ss,set);
        System.out.println(list);
    }

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();
        String[] sarray=new String[]{"a","b"};
        for(String tmps:sarray){
            set.add(tmps);
        }
        String ss=("abab");
//        String ss=("aa");

        testWith(ss, set);

    }





}
