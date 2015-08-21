package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashMap;

public class Anagrams {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	ArrayList<String> reslist = new ArrayList<String>();
	int[] num = new int[26];

	public ArrayList<String> anagrams(String[] strs) {
		for (int j = 0; j < strs.length; j++) {
			String s = strs[j];
			char[] cc = s.toCharArray();
			for (char c : cc) {
				num[c - 'a']++;
			}
			String skey = "";
			for (int i = 0; i <26; i++) {
				skey = skey + num[i] + ",";
			}
			Integer value = map.get(skey);
			if (value == null) {
				map.put(skey, j);
			}else
			if (value >= 0) {
				reslist.add(strs[value]);
				reslist.add(strs[j]);
				map.put(skey, -1);
			} else {
				reslist.add(strs[j]);
			}
			for (int i = 0; i < 26; i++) {
				num[i] = 0;
			}
		}
		return reslist;
	}
	
	public static void main(String[] args) {
		Anagrams ag=new Anagrams();
		System.out.println(ag.anagrams(new String[]{"abc","cba"}));
	}
}
