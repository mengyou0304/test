package com.robin3;

import java.util.ArrayList;
import java.util.List;

import com.robin3.utility.DataGen2;

public class GenerateParrentness {
	ArrayList<String> reslist=new ArrayList<String>();
    char[] cc;
    int count=0;
    public List<String> generateParenthesis(int n) {
        cc=new char[2*n];
        count=n;
        dp(0,0,0);
        return reslist;
    }
    public void dp(int p,int left,int step){
        if(step==count-1){
        		cc[p++]='(';
            for(int i=0;i<=left;i++)
                cc[p++]=')';
            reslist.add(new String(cc));
            return;
        }
        cc[p++]='(';
        for(int i=0;i<=left+1;i++){
            dp(p,left+1-i,step+1);
            if(p>=count*2)
            		break;
            cc[p++]=')';
        }
    }
    public static void main(String[] args) {
    		GenerateParrentness gp=new GenerateParrentness();
    		List<String> list=gp.generateParenthesis(3);
    		for(String s:list)
    			System.out.println(s);
	}
}
