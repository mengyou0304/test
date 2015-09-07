package com.robin4.newc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by robinmac on 15-9-4.
 */
public class ParlindromPermutation {
    List<String> list=new ArrayList<String>();
    char[] res;
    HashMap<Character,Integer> ocMap=new HashMap<Character,Integer>();

    public List<String> generatePalindromes(String s) {
        char[] cc=s.toCharArray();
        res=new char[cc.length];
        int singleNum=0;
        int singlec=0;
        for(char c:cc){
            singlec=singlec^c;
            Integer oc=ocMap.get(c);
            if(oc==null)
                oc=0;
            oc++;
            if((oc&1)==1){
                singleNum++;
            }
            else
                singleNum--;
            ocMap.put(c,oc);
        }
        if(singleNum>1)
            return list;
        if(singlec!=0)
            ocMap.put((char)singlec,ocMap.get((char)singlec)-1);
        Character[] cs=ocMap.keySet().toArray(new Character[0]);
        if(singleNum==1){
            res[res.length/2]=(char)singlec;
            goThrough(res.length/2-1,res.length/2+1,cs);
        }else{
            goThrough(res.length/2-1,res.length/2,cs);
        }
        return list;
    }
    public void goThrough(int st,int ed,Character[] cs){
        if(st<0||ed>=res.length){
            list.add(String.valueOf(res));
            return;
        }
        for(char c: cs){
            if(ocMap.get(c)==0)
                continue;
            ocMap.put(c,ocMap.get(c)-2);
            res[st]=c;
            res[ed]=c;
            goThrough(st - 1, ed + 1, cs);
            ocMap.put(c, ocMap.get(c)+2);
        }
    }

    public static void main(String[] args) {
        ParlindromPermutation pp=new ParlindromPermutation();
        System.out.println(pp.generatePalindromes("aa"));
    }
}
