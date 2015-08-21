package cn.jsi.buaa;

public class ZigZagConversion {
	boolean isdebug=false;
	public String getSpace(int n){
		String s="";
		if(isdebug)
		for(int i=0;i<n;i++)
			s+=" ";
		
		return s;
			
	}
	public String convert(String s, int n) {
		int b=2*n-2;
		char[] ss=s.toCharArray();
		int len=ss.length;
		String res = "";
		for(int i=0;i<n;i++){
			for(int j=0;j-b<len;j=j+b){
			//	System.out.println("i="+i+" j="+j);
				if(i==0){
					if(j<len)
					res+=ss[j]+getSpace(n-2);
					continue;
				}
				if(i==n-1){
					if((n+j-1)<len){
						res+=ss[(n+j-1)]+getSpace(n-2);
					}
					continue;
				}
				int v1=j-i;
				int v2=j+i;
				if(v1>0&&v1<len)
					res+=ss[v1]+getSpace(i-1);
				if(v2>0&&v2<len)
					res+=ss[v2]+getSpace(n-2-i);
			}
		//	System.out.println(res);
			if(isdebug)
			res+="\n";
		}
		return res;
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		String s=z.convert("0123456789abcd", 5);
		System.out.println("********");
		
		System.out.println(s);
	}

}
