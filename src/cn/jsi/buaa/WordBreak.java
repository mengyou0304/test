package cn.jsi.buaa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {
	char[] ls;
	class TN {
		Character value;
		HashMap<Character, TN> sons = new HashMap<Character, TN>();

		TN(Character c) {
			value = c;
		}

		TN add(Character c) {
			TN node = new TN(c);
			sons.put(c, node);
			return node;
		}

		void ends(TN node) {
			sons.put('#',node);
		}

		TN get(Character c) {
			return sons.get(c);
		}
		
	}

	public TN buildTire(Set<String> dict) {
		TN head = new TN('#');
		TN fatherNode = head;
		for (String s : dict) {
			fatherNode=head;
			char[] ss = s.toCharArray();
			if(ss.length==0)
				continue;
			for (int i = 0; i < ss.length; i++) {
				TN tnode = fatherNode.get(ss[i]);
				if (tnode == null)
					tnode = fatherNode.add(ss[i]);
				fatherNode = tnode;
			}
			fatherNode.ends(head);
		}
		return head;

	}

	public boolean goThrough(TN head,int i){
		if(i==ls.length){
			if(head.get('#')!=null)
			return true;
			else 
				return false;
		}
		
		TN	p1=head.get(ls[i]);
		TN  p2=head.get('#');
		boolean b1=false;
		boolean b2=false;
		if(p1!=null)
			b1=goThrough(p1,i+1);
		if(b1)
			return true;
		if(p2!=null)
			b2=goThrough(p2,i);
		if(b2)
			return true;
		return false;
	}
	public boolean wordBreak(String s, Set<String> dict) {
		TN head = buildTire(dict);
		debugTire(head,0);
		 ls=s.toCharArray();
		boolean b= goThrough(head,0);
		return b;
	}

	private void debugTire(TN node,int level) {
		Iterator<Character> it = node.sons.keySet().iterator();
		String s="";
		for(int i=0;i<level;i++)
			s+="     ";
		while (it.hasNext()) {
			Character key = it.next();
			TN newnode=node.sons.get(key);
			System.out.println(s+node.value+" -> " + key);
			if(key!='#')
			debugTire(newnode,level+1);
		}
	}

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> s = new HashSet<String>();
		String[] sarray=new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for(String tmps:sarray){
			s.add(tmps);
		}
		boolean b=wb.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", s);
		System.out.println(b);
	}

}
