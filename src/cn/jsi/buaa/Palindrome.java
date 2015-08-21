package cn.jsi.buaa;

public class Palindrome {
	public boolean isPalindrome(String s) {
		if (s == null||s.length() == 0)
			return true;
		s=s.trim();
		String[] com=new String[]{" ",",","\\?","!","\\.",";","@","#","$","%","^","&","\\*","\\(","\\)",":","-","'","=","\\+","\""};
		for(String ts:com){
			if(s.length()==0)
				return true;
			s=s.replaceAll(ts, "");
		}
		s = s.toLowerCase();
		if(s.length() == 0)
		    return true;
        char[] ss=s.toCharArray();
        int len=ss.length;
        int start=0,end=len-1;
        while(start<=end){
            if(ss[start]!=ss[end])
                return false;
            start++;
            end--;
        }
        return true;
	}
	public static void main(String[] args) {
		Palindrome p=new Palindrome();
		p.isPalindrome("a");
	}

}
