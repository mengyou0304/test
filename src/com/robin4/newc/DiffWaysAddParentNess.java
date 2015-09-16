package com.robin4.newc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by robinmac on 15-9-13.
 */
public class DiffWaysAddParentNess {
    HashMap<String,ArrayList<Integer>> resMap=new HashMap<String,ArrayList<Integer>>();
    ArrayList<Integer> nums=new ArrayList<Integer>();
    //+ 1
    //- 2
    //* 3
    ArrayList<Integer> ops=new ArrayList<Integer>();

    public List<Integer> diffWaysToCompute(String input) {
        char[] cc=input.toCharArray();
        int k=0;
        for(int i=0;i<cc.length;i++){
            if(cc[i]=='+')
                ops.add(1);
            if(cc[i]=='-')
                ops.add(2);
            if(cc[i]=='*')
                ops.add(3);
            if(cc[i]>'9'||cc[i]<'0'){
                nums.add(k);
                k=0;
            }else
                k=k*10+cc[i]-'0';
        }
        nums.add(k);
        // 1 2 3 4 5    nums
        //  - + - *     ops
        ArrayList<Integer> res=getComput(0,nums.size()-1);
        return res;
    }
    //st ed->nums
    private ArrayList<Integer> getComput(int st,int ed){
        ArrayList<Integer> savedRes=resMap.get(st+"-"+ed);
        if(savedRes!=null)
            return savedRes;
        savedRes=new ArrayList<Integer>();
        resMap.put(st+"-"+ed,savedRes);
        //comput logic
        if(st==ed){
            savedRes.add(nums.get(st));
            return savedRes;
        }
        for(int i=st;i<ed;i++){
            ArrayList<Integer> resleft=getComput(st,i);
            ArrayList<Integer> resright=getComput(i+1,ed);
            int v=ops.get(i);
            for(Integer v1: resleft)
                for(Integer v2: resright){
                    if(v==1)
                        savedRes.add(v1+v2);
                    if(v==2)
                        savedRes.add(v1-v2);
                    if(v==3)
                        savedRes.add(v1*v2);
                }
        }
        return savedRes;
    }

    public static void main(String[] args) {
        DiffWaysAddParentNess dp=new DiffWaysAddParentNess();
        System.out.println(dp.diffWaysToCompute("5-6-7-1"));
    }
}
