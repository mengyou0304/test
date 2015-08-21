package com.robin3;

import java.util.ArrayList;
import java.util.List;

import com.robin3.utility.DataGen2;

public class PalindromePartition {
	ArrayList<List<String>> reslist=new ArrayList<List<String>>();
    char[] cc;
    int[][] rec;
    public List<List<String>> partition(String s) {
        s1(s);
        return reslist;
    }
    
    /**
     * Solution1: first find all the palindrome and then split
     */
    public void s1(String s){
        cc=s.toCharArray();
        rec=new int[cc.length+5][cc.length+5];
        //method1: find all the palindrome
        for(int i=cc.length-1;i>=0;i--)
            for(int j=i;j<cc.length;j++)
                if(cc[j]==cc[i]&&(j-i<2||rec[i+1][j-1]==1))
                    rec[i][j]=1;
        dp(new ArrayList<String>(),0);
    }
    public void dp(ArrayList<String> clist,int p){
        if(p>=cc.length){
            ArrayList<String> tlist=new ArrayList<String>();
            for(String ts:clist)
                tlist.add(ts);
            reslist.add(tlist);
        }
        String cp="";
        for(int i=p;i<cc.length;i++){
            cp+=cc[i];
            if(rec[p][i]==1){
                clist.add(cp);
                dp(clist,i+1);
                clist.remove(clist.size()-1);
            }
        }
    }
    public static void main(String[] args) {
    	PalindromePartition pp=new PalindromePartition();
    	DataGen2.ShowLL(pp.partition("amanaplanacanalpanama"));
    	
	}
}
