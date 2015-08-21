package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DebugGraphics;

public class Wordbreak2S1 {
	public void debugInput(String st) {
		char[] cc = st.toCharArray();

		for (int i = 0; i < cc.length; i++)
			System.out.print("  " + cc[i]);
		System.out.println();
		for (int i = 0; i < cc.length; i++)
			System.out.printf("%3d", i);
		System.out.println();

	}

	public static void main(String[] args) {
		Wordbreak2S1 wb = new Wordbreak2S1();
		Set<String> s = new HashSet<String>();
		String[] sarray = new String[] { "a", "aa", "aaa", "aaaa", "aaaaa",
				"aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
		//sarray = new String[] { "a" };
		String st="aaaaaaaaa";
	//	wb.debugInput(st);
		for (String tmps : sarray) {
			s.add(tmps);
		}
		// boolean
		// b=wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
		// s);
		ArrayList<String> list = wb.wordBreak(st, s);
		System.out.println(list);
	}
	ArrayList<String> res=new ArrayList<String>();
	//dirct[i][j]==1 means s[i]can directly goto s[j];
	//though direct is a large table we only concern about the point from the start
	int[][] direct;
	//allow[i] means i can go to the end;
	boolean[] allow;
	boolean[] cango;
	String bases;
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		bases=s;
		direct=new int[s.length()+1][s.length()+1];
	//	System.out.println(direct.length+" "+direct[0].length);
		allow=new boolean[s.length()+1];
		cango=new boolean[s.length()+1];
		for(int i=0;i<s.length();i++){
			allow[i]=false;
			cango[i]=false;
		}
		cango[0]=true;
		//fill the direct by the help of cango
		for(int i=0;i<s.length();i++){
			if(!cango[i])
				continue;
			for(String ts:dict){
				int len=ts.length();
				if(i+len>bases.length())
					continue;
				if(bases.substring(i, i+len).equals(ts)){
					direct[i][i+len]=1;
					cango[i+len]=true;
					if(i+len==s.length())
						allow[i]=true;
				}
			}
		}
//		System.out.println("finding finish");
		//find all allow as a head of  a dfs to list all the possible result
		for(int i=0;i<s.length();i++)
			if(allow[i])
				genRes(i,bases.substring(i,bases.length()));
		return res;
	}

	private void genRes(int k,String s) {
		if(k==0){
			res.add(s);
			return;
		}
		for(int i=0;i<k;i++){
			if(direct[i][k]==1)
				genRes(i,bases.substring(i,k)+" "+s);
		}
	}
}
