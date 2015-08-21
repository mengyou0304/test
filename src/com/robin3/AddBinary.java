package com.robin3;

public class AddBinary {
	public String addBinary(String a, String b) {
        char[] c1=a.toCharArray();
        char[] c2=b.toCharArray();
        int maxlen=Math.max(c1.length,c2.length);
        int jin=0;
        int noz=-1;
        String res="";
        int i=0;
        for(;i<maxlen+3;i++){
        		int v=jin;
        		if(c1.length-1-i>=0)
        			v+=(int)(c1[c1.length-1-i]-'0');
        		if(c2.length-1-i>=0)
        			v+=(int)(c2[c2.length-1-i]-'0');
            if(v>1){
                v=v-2;
                jin=1;
            }else
                jin=0;
            if(v!=0)
                noz=i;
            res=v+res;
        }
        return res.substring(maxlen+2-noz);
    }
	public static void main(String[] args) {
		AddBinary ab=new AddBinary();
		String res=ab.addBinary("111", "1");
		System.out.println(res);
	}

}
