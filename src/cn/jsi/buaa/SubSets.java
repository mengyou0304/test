package cn.jsi.buaa;

import java.util.ArrayList;

public class SubSets {
	int[] ss;
    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> tmp=new ArrayList<ArrayList<Integer>> ();
    
    ArrayList<Integer> tlist=new ArrayList<Integer>();
    public int partition(int start,int end){
        int x=ss[end];
        int i=start-1;
        int tmp=0;
        for(int j=start;j<end;j++){
            if(ss[j]<x){
                i++;
                tmp=ss[j];
                ss[j]=ss[i];
                ss[i]=tmp;
            }
        }
        i++;
        tmp=x;
        ss[end]=ss[i];
        ss[i]=x;
        return i;
     }
    public void qsortd(int start,int end){
        if(start>=end)
        	return;
         int i=partition(start,end);
         qsortd(start,i-1);
         qsortd(i+1,end);
        
    }
    public void genOne(ArrayList<Integer> list, int i){
        ArrayList<Integer> nl=new ArrayList<Integer>();
        if(list!=null)
             for(int j:list)
                  nl.add(j);
        nl.add(i);
        tmp.add(nl);
    }
    public void genRes(){
        for(int i:ss){
            genOne(null,i);
            for(ArrayList<Integer> list:res){
                genOne(list,i);
            }
            res.addAll(tmp);
            tmp.clear();
        }
        
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        ss=s;
        qsortd(0,s.length-1);
        genRes();
        return res;
    }
    public static void main(String[] args) {
    	SubSets s=new SubSets();
    	s.subsets(new int[]{0});
	}
}
