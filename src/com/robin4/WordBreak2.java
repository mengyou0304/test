package com.robin4;

import java.util.*;

/**
 * Created by robinmac on 15-8-25.
 */
public class WordBreak2 {

    ArrayList<String> reslist=new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        char[] cc=s.toCharArray();
        int maxlen=0;
        for(String word:wordDict)
            maxlen=Math.max(maxlen,word.length());
        HashMap<Integer,ArrayList<String>> map= new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> tlist=new ArrayList<String>();
        tlist.add("");
        map.put(-1,tlist);
        byte[] cango=new byte[cc.length];
        Arrays.fill(cango,(byte)0);
        //0123
        //abcd  {"ab","cd"}
        for(int i=0;i<cc.length;i++){
            String temps="";
            for(int j=i;j>=0&&i-j<=maxlen;j--){
                temps=cc[j]+temps;
                if((j==0||cango[j-1]==1)&&wordDict.contains(temps)){
                    ArrayList<String> nlist=map.get(i);
                    if(nlist==null){
                        nlist=new ArrayList<String>();
                        map.put(i,nlist);
                    }
                    ArrayList<String> list=map.get(j-1);
                    if(list==null){
                        list=new ArrayList<String>();
                        map.put(j-1,list);
                        continue;
                    }
                    for(String ts:list)
                        nlist.add(ts+" "+temps);
                    cango[i]=1;
                }
            }
            if(cango[i]!=1)
                cango[i]=-1;
        }
        return map.get(cc.length-1);
    }


    public static void testWith(String ss,HashSet<String> set){
        WordBreak2 wb=new WordBreak2();
        List<String> list=wb.wordBreak(ss,set);
        System.out.println(list);
    }

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();
        String[] sarray=new String[]{"a","aa",};
        for(String tmps:sarray){
            set.add(tmps);
        }
        String ss=("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
//        String ss=("aa");

        testWith(ss,set);

    }


}
