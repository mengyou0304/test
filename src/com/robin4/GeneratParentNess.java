package com.robin4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robinmac on 15-9-8.
 */
public class GeneratParentNess {
    ArrayList<String> reslist=new ArrayList<String>();
    char[] res;
    public List<String> generateParenthesis(int n) {
        res=new char[2*n];
        goThrough(0,0,0);
        return reslist;
    }
    private void goThrough(int p,int leftnum,int rightnum){
        if(p==res.length){
            reslist.add(String.valueOf(res));
            return;
        }
        if(leftnum>rightnum){
            res[p]=')';
            goThrough(p+1,leftnum,rightnum+1);
        }
        if(leftnum<res.length/2){
            res[p]='(';
            goThrough(p+1,leftnum+1,rightnum);
        }
    }

    public static void main(String[] args) {
        GeneratParentNess m=new GeneratParentNess();
        System.out.println(m.generateParenthesis(3));
    }
}
