package com.robin3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Anagans {
	public List<String> anagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<String,ArrayList<String>> ();
        for(String s: strs){
            int[] vs=new int[27];
            char[] cc=s.toCharArray();
            for(Character c:cc)
                vs[(int)(c-'a')]++;
            String key=toKey(vs);
            if(map.containsKey(key))
                map.get(key).add(s);
            else{
                ArrayList<String> list=new ArrayList<String>();
                list.add(s);
                map.put(key,list);
            }
        }
        Set<String> keyset=map.keySet();
        ArrayList<String> reslist=new ArrayList<String>();
        for(String key:keyset){
            ArrayList<String> vlist=map.get(key);
            if(vlist.size()>1)
                reslist.addAll(vlist);
        }
        return reslist;
    }
    public String toKey(int[] vs){
        String s="";
        for(int i:vs)
            s+=i+'-';
        return s;
    }

}
