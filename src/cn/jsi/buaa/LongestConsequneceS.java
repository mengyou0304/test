package cn.jsi.buaa;

import java.util.HashMap;
import java.util.Iterator;

public class LongestConsequneceS {
	public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i:num){
            map.put(i,1);
            if(min>i)
                min=i;
            if(max<i)
                max=i;
        }
        Iterator<Integer> it=map.keySet().iterator();
        int maxlen=0;
        while(it.hasNext()){
            int v=it.next();
            Integer value=map.get(v);
            if(value==null)
            	continue;
            map.put(v,0);
            int len=-1;
            if(value==1){
                int i,j;
                for(i=v-1;i>=min;i--){
                    Integer tmp=map.get(i);
                    if(tmp==null)
                    	break;
                    map.put(i,0);
                    if(tmp!=1)
                        break;
                }
                for(j=v+1;j<=max;j++){
                	Integer tmp=map.get(j);
                	 if(tmp==null)
                     	break;
                    map.put(j,0);
                    if(tmp!=1)
                        break;
                }
                len=j-i-1;
                if(maxlen<len)
                    maxlen=len;
            }
        }
        return maxlen;
    }
	
    public static void main(String[] args) {
    	LongestConsequneceS lc=new LongestConsequneceS();
    	int v=lc.longestConsecutive(new int[]{0,-1,1,2});
    	System.out.println(v);
	}

}
