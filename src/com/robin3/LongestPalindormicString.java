package com.robin3;

public class LongestPalindormicString {
	public String longestPalindrome(String s) {
  	    char[] cc=s.toCharArray();
  	    String res="";
  	    int maxlen=-1;
  	    for(int i=0;i<cc.length*2;i++){
  	        if(i/2-maxlen<0||i/2+maxlen>=cc.length)
  	            continue;
  	        int j=0;
  	        if(i%2==1)
  	        		j=1;
  	        for(;j<=cc.length;j=j+2){
  	            if(i-j<0||(i+j)/2>=cc.length)
  	                break;
  	            if(cc[(i-j)/2]!=cc[(i+j)/2])
  	                break;
  	            if(maxlen*2<j){
  	                maxlen=j/2;
  	                res=s.substring((i-j)/2,(i+j)/2+1);
  	            }
  	        }
  	    }
  	    return res;
  	}
	public static void main(String[] args) {
		LongestPalindormicString lp=new LongestPalindormicString();
		String s=lp.longestPalindrome("aaaaa");
		System.out.println("s="+s);
	}

}
