package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashSet;

public class WordLadderS2 {
	HashSet<String> usedmap = new HashSet<String>();
	HashSet<String> dictmap;
	Character[] ch;

	public ArrayList<String> getNext(String ts) {
		ArrayList<String> candis = new ArrayList<String>();
		char[] ss = ts.toCharArray();
		String res = null;
		for (int j = 0; j < ss.length; j++) {
			ss = ts.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				ss[j] = ch[i];
				res = String.valueOf(ss);
				if (dictmap.contains(res) && !usedmap.contains(res)) {
					candis.add(res);
				}
			}
		}
		return candis;

	}

	public int dictBFS(String start, String end) {
		ArrayList<String> levelres = new ArrayList<String>();
		ArrayList<String> tres = new ArrayList<String>();
		int level = 2;
		levelres.add(start);
		int it = 0;
		while (true) {
			while (it < levelres.size()) {
				String father = levelres.get(it);
				ArrayList<String> sons = getNext(father);
				for (String son : sons) {
					if (son.equals(end))
						return level;
					if (!usedmap.contains(son)) {
						tres.add(son);
						usedmap.add(son);
					}
				}
				it++;
			}
			// System.out.println("level="+level);
			// for(String ts:tres)
			// System.out.print(ts+"  ");
			// System.out.println();
			level++;
			levelres = tres;
			tres = new ArrayList<String>();
			it = 0;
			if (levelres.size() == 0)
				break;
		}
		return 0;

	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
		dict.add(end);
		dictmap = dict;
		ch = new Character[26];
		ch[0] = 'a';
		for (int i = 0; i < ch.length; i++)
			ch[i] = (char) (ch[0] + i);
		return dictBFS(start, end);
	}

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		String[] dic = new String[] { "hot", "dot", "dog", "lot", "log" };
		for (String ts : dic)
			dict.add(ts);
		String s1 = "hit";
		String s2 = "cog";
		s1.toCharArray();
		WordLadderS2 ws = new WordLadderS2();
		int v = ws.ladderLength(s1, s2, dict);
		System.out.println(v);

	}

}
