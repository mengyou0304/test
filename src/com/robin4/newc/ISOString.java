package com.robin4.newc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by robinmac on 15-9-9.
 */
public class ISOString {
    ArrayList<String> list1=new ArrayList<String>();
    ArrayList<String> list2=new ArrayList<String>();

    HashMap<String,Integer> map=new HashMap<String,Integer>();

    public boolean isIsomorphic(String s, String t) {
        if(s==null||t==null)
            return false;
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        if(c1.length!=c2.length)
            return false;
        for(int i=0;i<256;i++){
            list1.add("");
            list2.add("");
        }

        for(int i=0;i<c1.length;i++){
            char ca=c1[i];
            char cb=c2[i];
            list1.set(ca , list1.get(ca ) + i);
            list2.set(cb , list2.get(cb ) + i);
        }
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).length()!=0)
                map.put(list1.get(i),i);
        }
        for(int i=0;i<list2.size();i++){
            if(list2.get(i).length()!=0)
                map.remove(list2.get(i));
        }
        if(map.size()==0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        ISOString iso=new ISOString();
//        System.out.println(iso.isIsomorphic("paper","title"));
        System.out.println(iso.isIsomorphic("aaa","bbb"));
    }
}
