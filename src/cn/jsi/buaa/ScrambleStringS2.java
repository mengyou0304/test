package cn.jsi.buaa;

public class ScrambleStringS2 {
	char[] c1;
	char[] c2;
	int alllen;
	int mem[][][];
	 public boolean isScramble(String s1, String s2) {
		 if(s1.length()!=s2.length())
			 return false;
		 c1=s1.toCharArray();
		 c2=s2.toCharArray();
		 alllen=c1.length;
		 mem=new int[alllen][alllen][alllen];
		
		 return false;
	 }
	 
	 public static void main(String[] args) {
		 ScrambleStringS2 ss=new ScrambleStringS2();
		 boolean b=ss.isScramble("great", "rgtae");
		 System.out.println(b);
	}


}
