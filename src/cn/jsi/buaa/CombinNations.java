package cn.jsi.buaa;

import java.util.ArrayList;

public class CombinNations {
	public static void main(String[] args) {
		CombinNations c=new CombinNations();
		  ArrayList<ArrayList<Integer>> list=c.combine(12, 5);
		  for(  ArrayList<Integer> li:list){
			  for(Integer i:li)
				  System.out.print(i+" " );
			  System.out.println();
		  }
	}
	  ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	    int re[];
	    int n;
	    int k;
	    public void genRes(){
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        for(int i:re){
	            list.add(i);
	        }
	        res.add(list);
	    }
	    public void decideL(int level){
	    //	System.out.println("level="+level+"  k="+k);
	        if(level>=k){
	            genRes();
	            return;
	        }
	        int startv=-1;
	        if(level==0)
	            startv=0;
	        else
	            startv=re[level-1];
	        for(int j=startv+1;j<=n;j++){
	            re[level]=j;
	            decideL(level+1);
	        }
	        
	    }
	  
	    public ArrayList<ArrayList<Integer>> combine(int N, int K) {
	       n=N;
	       k=K;
	       re=new int[k];
		   for(int i=0;i<k;i++)
	            re[i]=-1;
	       decideL(0);
	       return res;
	    }

}
