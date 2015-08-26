package com.robin4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by robinmac on 15-8-25.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        char[]  cc=s.toCharArray();
        byte[] cango=new byte[cc.length+1];
        int maxlen=0;
        for(String word:wordDict)
            maxlen=Math.max(maxlen, word.length());
        Arrays.fill(cango,(byte)0);
        for(int i=0;i<cc.length;i++){
            String tmps="";
            for(int j=i;j>=0&&(i-j)<=maxlen;j--){
                tmps=cc[j]+tmps;
                if(j!=0&&cango[j-1]==-1)
                    continue;
                if((j==0||cango[j-1]==1)&&wordDict.contains(tmps)){
                    cango[i]=1;
                    break;
                }
            }
            if(cango[i]!=1)
                cango[i]=-1;
        }
        return (cango[cc.length-1]==1);
    }

    public static void main(String[] args) {
        WordBreak wb=new WordBreak();
//        Set<String> set=new HashSet<String>();
//        String[] ss=new String[]{"cat", "cats", "and", "sand", "dog"};
//        for(String s:ss)
//            set.add(s);
//        boolean res=wb.wordBreak("a",set);
//        System.out.println(res);

        Set<String> s = new HashSet<String>();
        String[] sarray=new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        for(String tmps:sarray){
            s.add(tmps);
        }
        boolean b=wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", s);
        System.out.println(b);

    }
}
