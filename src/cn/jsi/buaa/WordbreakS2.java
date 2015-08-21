package cn.jsi.buaa;

import java.util.HashSet;
import java.util.Set;

public class WordbreakS2 {
	Set<String> sset;
	String st;
	int[] res;
	private boolean dp1(int start){
		if(res[start]!=0){
			if(res[start]>0)
				return true;
			else
				return false;
		}
		boolean success=false;
		for(int i=st.length();i>=start+1;i--){
			String tmp=st.substring(start,i);
			//System.out.println("tmp=["+start+","+i+"]"+tmp);
			if(sset.contains(tmp)){
				if(i==st.length()){
					res[start]=1;
					return true;
				}
				else
					success=dp1(i);
			}
			if(success){
				res[start]=1;
				 return true;
			}
				
		}
		res[start]=-1;
		return false;
	}
	
	public boolean wordBreak(String s, Set<String> ss) {
		sset=ss;
		st=s;
		res=new int[s.length()+10];
		return dp1(0);
	}
	public static void main(String[] args) {
		WordbreakS2 wb = new WordbreakS2();
		Set<String> s = new HashSet<String>();
		String[] sarray=new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		sarray=new String[]{"a"};
		
		for(String tmps:sarray){
			s.add(tmps);
		}
//		boolean b=wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", s);
		boolean b=wb.wordBreak("a", s);
		
		System.out.println(b);
	}

	private void debugInput(){
		char[] cc=st.toCharArray();
		
		for(int i=0;i<cc.length;i++)
			System.out.print("  "+cc[i]);
		System.out.println();
		for(int i=0;i<cc.length;i++)
			System.out.printf("%3d",i);
		System.out.println();
		
	}

}
