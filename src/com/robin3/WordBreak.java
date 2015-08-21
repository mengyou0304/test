package com.robin3;

import java.util.Set;

public class WordBreak {
	int[] pos;
    int len;
    String line;
    int maxlen=0;
    int minlen=Integer.MAX_VALUE;
    boolean res=false;
    Set<String> dict;
    public boolean wordBreak(String s, Set<String> dict) {
        line=s;
        len=s.length();
        pos=new int[len+1];
        this.dict=dict;
        for(String dic:dict){
            maxlen=Math.max(dic.length(),maxlen);
            minlen=Math.min(dic.length(),minlen);
        }
        dp(len);
        return res;
    }
    public void dp(int currentlen){
        if(currentlen==0){
            res=true;
            return;
        }
        if(pos[currentlen]!=0)
            return;
        pos[currentlen]=1;
        for(int i=minlen;i<=maxlen;i++){
            if(pos[currentlen-i]!=0)
                continue;
            String s=line.substring(currentlen-i,currentlen);
            if(dict.contains(s)){
                dp(currentlen-i);
            }
            if(res)
                return;
        }
        pos[currentlen]=-1;
    }
    public static void main(String[] args) {
		
	}

}
