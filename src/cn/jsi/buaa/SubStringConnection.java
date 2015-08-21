package cn.jsi.buaa;

import java.util.ArrayList;

public class SubStringConnection {
		char[] ss;
	    char[][] ts;
	    int[] tp;
	    int baselen;
	    ArrayList<Integer> re=new ArrayList<Integer>();
	    public void m1(){
	        for(int i=0;i<ts.length;i++){
	            boolean iseq=true;
	            int len=0;
	            for(int j=0;j<ss.length;j++){
	                if(ss[j]==ts[i][len]){
	                   if(len==baselen-1){
	                        len=0;
	                        tp[j-len+1]=i;
	                    }else
	                        len++;
	                    
	                }else{
	                    j=j-len+2;
	                    len=0;
	                  
	                }
	            }
	        }
	        
	    }
	    public ArrayList<Integer> findSubstring(String S, String[] L) {
	        if(L.length==0)
	            return re;
	        ss=S.toCharArray();
	        tp=new int[ss.length+1];
	        ts=new char[L.length][];
	        baselen=L[0].length();
	        for(int i=0;i<L.length;i++)
	            ts[i]=L[i].toCharArray();
	        for(int i=0;i<tp.length;i++)
	            tp[i]=-1;
	        m1();
	        return re;
	    }
	    public static void main(String[] args) {
	    	SubStringConnection ss=new SubStringConnection();
	    	ss.findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
		}
}
