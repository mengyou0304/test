package cn.jsi.buaa;

import java.util.LinkedList;
import java.util.Queue;

public class WaterTrap {
	 Queue<Integer> q;
		int waterAll=0;
		public void countWater(int level){
		    int cl=0;
		    while(q.size()>0){
		        cl=q.poll();
		        waterAll+=level-cl;
		    }
		}
	    public void force1(int[] a){
	        int maxn=0;
	        int len=a.length;
	        int laststep=0;
	        for(int i=0;i<len;i++){
	            if(a[i]>=maxn){
	                countWater(maxn);
	                maxn=a[i];
	                laststep=i;
	            }else
	                q.add(a[i]);
	            
	        }
	        q.clear();
	        maxn=0;
	        for(int i=len-1;i>=laststep;i--){
	            if(a[i]>=maxn){
	                countWater(maxn);
	                maxn=a[i];
	            }else{
	                q.add(a[i]);
	            }
	        }
	    }
	    public int trap(int[] A) {
	        if(A.length==0)
	            return 0;
	        q=new LinkedList<Integer>();
	        force1(A);
	        return waterAll;
	        
	    }
	    public static void main(String[] args) {
	    	WaterTrap w=new WaterTrap();
	    	int v=w.trap(new int[]{4,2,3});
	    	System.out.println(v);
			
		}

}
