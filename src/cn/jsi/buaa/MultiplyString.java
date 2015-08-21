package cn.jsi.buaa;

public class MultiplyString {
	 int[] res;
	    int[] s1;
	    int[] s2;
	    int len1;
	    int len2;
	    
	    public String multiply(String num1, String num2) {
	        char[] c1=num1.toCharArray();
	        char[] c2=num2.toCharArray();
	        s1=new int[c1.length];
	        s2=new int[c2.length];
	        int len1=c1.length;
	        int len2=c2.length;
	        for(int i=0;i<len1;i++){
	        	s1[len1-1-i]=c1[i]-'0';
	        }
	        for(int i=0;i<len2;i++){
	        	s2[len2-1-i]=c2[i]-'0';
	        }
	        res=new int[len1+len2+3];
	        for(int i=0;i<len1;i++)
	        	for(int j=0;j<len2;j++)
	        		res[i+j]+=s1[i]*s2[j];
	       // debugRes();
	        for(int i=0;i<res.length-1;i++){
	        	res[i+1]+=res[i]/10;
	        	res[i]=res[i]%10;
	        }
	        debugRes();
	        String s="";
	        boolean leadz=true;
	        for(int i=res.length-1;i>=0;i--){
	        	if(leadz&&res[i]==0)
	        		continue;
	        	if(res[i]!=0)
	        		leadz=false;
	        	s+=res[i];
	        }
	        if(s.length()==0)
	        		s="0";
	        return s;
	    }
	    private void debugRes() {
	    	   for(int i=res.length-1;i>=0;i--){
	    		   	System.out.print(res[i]+" ");
	    	   }
	    	   System.out.println();
			
		}
		public static void main(String[] args) {
	    	MultiplyString m=new MultiplyString();
	    	String s=m.multiply("19", "12");
	    	System.out.println(s);
		}

}
