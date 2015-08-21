package cn.jsi.buaa;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Q2 {
	int maxvalue;
	int position[][];
	int place[];
	int basiclen;
	int alllen;

	static String inS;
	static String[] inL;
	public void init(String S, String[] L) {
		maxvalue=S.length()/(L[0].length()*L.length);
		place = new int[L.length];
		basiclen = L[0].length();
		alllen=basiclen*L.length;
		System.out.println("alllen="+alllen);
	}

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		init(S,L);
		String tmp=String.valueOf(S);
		String candi="=";
		String matches="";
		for(String ts:L){
			matches+=candi;
			tmp=tmp.replaceAll(ts, candi);
		}
		
		ArrayList<Integer> slist=new ArrayList<Integer>();
		int autoadd=0;
		while(tmp.indexOf(matches)!=-1) {
			System.out.println("tmp="+tmp+"   autoadd="+autoadd);
			slist.add(tmp.indexOf(matches)+autoadd);
			tmp=tmp.replaceFirst(matches, "");
			autoadd+=(basiclen)*L.length;
		//	System.out.println("tmp="+tmp);
		}
		
		for(Integer m:slist)
			System.out.println("we get as"+m);
		int shouldRemove[]=new int[slist.size()+1];
		for(int i=0;i<slist.size();i++){
			System.out.println("getting "+slist.get(i)+" "+(slist.get(i)+alllen)+"  len="+S.length());
			if(slist.get(i)+alllen<=S.length())
				tmp=S.substring(slist.get(i),slist.get(i)+alllen);
			else{
				tmp=S.substring(slist.get(i),S.length()-1);
			}
			for(String ts:L){
				if(tmp.indexOf(ts)==-1){
					shouldRemove[i]=1;
					break;
				}
			}
		}
		for(int i=slist.size()-1;i>=0;i--){
			if(shouldRemove[i]==1)
				slist.remove(i);
		}
		
		
		return slist;
	}
	public void initInput(int i){
		if(i==0){
			inL=new String[]{"aba","bab","abc"};
			inS="aba bab abc dsdas aba abc bab";
		}
		if(i==1){
			inL=new String[]{"ab","cd","ef"};
			inS="dddddabcdefssssabcdefsssssefcdab";
		}
		if(i==2){
			inL=new String[]{"ab","cd","ef"};
			inS="dddddababefssssabcdefsssssefcdab";
		}
			
		
		
		
	}
	public static void main(String[] args) {
//		Q2 q=new Q2();
//		q.initInput(0);
//		List<Integer> slist=q.findSubstring2(inS, inL);
//		for(Integer i:slist){
//			System.out.println(" result"+i);
//		}
		
	}
}
