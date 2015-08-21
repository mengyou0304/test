package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Sum3S1 {
	 int[] n;
	    public int partition(int start,int end){
	        int x=end;
	        int i=start-1;
	        int tmp;
	        for(int j=start;j<end;j++){
	            if(n[j]<=n[x]){
	                i++;
	                tmp=n[i];
	                n[i]=n[j];
	                n[j]=tmp;
	            }
	        }
	        i++;
	        tmp=n[x];
	        n[x]=n[i];
	        n[i]=tmp;
	        return i;
	    }
	    public void qsort(int start, int end){
	        if(start > end)
	            return;
	        int i=partition(start,end);
	        qsort(start,i-1);
	        qsort(i+1,end);
	        
	    }
	    HashSet<String> results=new HashSet<String>();
	    HashMap<Integer,Integer> nmap=new HashMap<Integer,Integer>();
	    
	    public void addRes(int i, int j){
	        int l=0-i-j;
	        if(l<=i){
	            int tmp=l;
	            l=j;
	            j=i;
	            i=tmp;
	        }
	        if(i<l&&l<=j){
	            int tmp=j;
	            j=l;
	            l=tmp;
	        }
	        if(i==j&&j==l){
	        	Integer m=nmap.get(i);
	        	if(m<3)
	        		return;
	        }
	        if(i==j||j==l){
	        	Integer m=nmap.get(j);
	        	if(m<2)
	        		return;
	        }
	        String s=""+i+","+j+","+l;
	        results.add(s);
	    }
	    public void genRes(ArrayList<ArrayList<Integer>> res){
	        Iterator<String> it=results.iterator();
	        while(it.hasNext()){
	            ArrayList<Integer> list=new ArrayList<Integer>();
	            String[] ss=it.next().split(",");
	            for(String ts:ss)
	                list.add(Integer.parseInt(ts));
	            res.add(list);
	        }
	    }
	    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        n=num;
	        qsort(0,n.length-1);
	        for(int i=0;i<n.length;i++){
	        	Integer m=nmap.get(n[i]);
	        	if(m==null)
	        		 m=1;
	        	else
	        		m++;
	            nmap.put(n[i], m);
	        }
	        for(int i=0;i<n.length;i++)
	            for(int j=i;j<n.length;j++){
	                int v=0-n[i]-n[j];
	                if(nmap.containsKey(v)){
	              //  	System.out.println("n[i]="+n[i]+" n[j]="+n[j]);
	                    addRes(n[i],n[j]);
	                }
	            }
	        ArrayList<ArrayList<Integer>> reslist=new ArrayList<ArrayList<Integer>>();
	        genRes(reslist);
	        return reslist;
	    }
	    public static void main(String[] args) {
	    	Sum3S1 s = new Sum3S1();
			long d1=System.currentTimeMillis();
			ArrayList<ArrayList<Integer>> res = s.threeSum(new int[] { 7, -1, 14,
					-12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15,
					-6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2,
					-15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9,
					-8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12,
					-2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14,
					3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13,
					14, -2, -5, -11, 1, 3, -6 });
			long d2=System.currentTimeMillis();
			long time=d2-d1;
			System.out.println("time: "+time);
			System.out.println(res);
		}

}
