package cn.jsi.buaa;

import java.util.HashMap;

public class ScrambleString {
	char[] c1;
	char[] c2;
	int alllen;
	int[][][][] mem;
	boolean isdebug=false;
	public boolean shelper(int start1,int end1,int start2,int end2){
		if(isdebug)
		System.out.printf("helper %d %d %d %d\n",start1,end1,start2,end2);
		if(mem[start1][end1][start2][end2]==1)
			return true;
		if(mem[start1][end1][start2][end2]==-1)
			return false;
		if(end1-start1<2){
			if(c1[start1]==c2[start2]&&c1[end1]==c2[end2])
				mem[start1][end1][start2][end2]=1;
			if(c1[start1]==c2[end2]&&c1[end1]==c2[start2])
				mem[start1][end1][start2][end2]=1;
			if(mem[start1][end1][start2][end2]==1){
				if(isdebug)
				System.out.println("true");
				return true;
			}
			else{
				mem[start1][end1][start2][end2]=-1;
				if(isdebug)
				System.out.println("false");
				return false;
			}
		}
		for(int i=start1;i<end1;i++){
			boolean issc1l=shelper(start1,i,start2,start2+(i-start1));
			boolean issc1r=shelper(i+1,end1,start2+(i-start1)+1,end2);
			boolean issc2l=shelper(start1,i,end2-(i-start1),end2);
			boolean issc2r=shelper(i+1,end1,start2,end2-(i-start1)-1);
			if((issc1l&&issc1r)||(issc2l&&issc2r)){
				mem[start1][end1][start2][end2]=1;
				return true;
			}
		}
		mem[start1][end1][start2][end2]=-1;
		return false;
	}
	 public boolean isScramble(String s1, String s2) {
		 if(s1.length()!=s2.length())
			 return false;
		 c1=s1.toCharArray();
		 c2=s2.toCharArray();
		 alllen=c1.length;
		 mem=new int[alllen][alllen][alllen][alllen];
		 return shelper(0,alllen-1,0,alllen-1);
	 }
	 
	 public static void main(String[] args) {
		 ScrambleString ss=new ScrambleString();
		 boolean b=ss.isScramble("great", "rgtae");
		 System.out.println(b);
	}

}
