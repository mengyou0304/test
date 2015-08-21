package cn.jsi.buaa;

import java.util.HashMap;

public class LongestSumbString {
	public int lengthOfLongestSubstring(String s) {
		char[] cc = s.toCharArray();
		int start = 0;
		Integer end = 0;
		int maxlen = -1;
		HashMap<Character, Integer> cset = new HashMap<Character, Integer>();
		while (end < cc.length) {
			 System.out.println("start="+start+"  end="+end);
			if (cset.containsKey(cc[end])) {
				int nstart = cset.get(cc[end]) + 1;
				if (start < nstart)
					start = nstart;
			}
			if (maxlen < end - start)
				maxlen = end - start;
			cset.put(cc[end], end);
			end++;
		}
		if (maxlen < end - start - 1)
			maxlen = end - start - 1;
		return maxlen + 1;
	}

	public static void main(String[] args) {
		LongestSumbString ls = new LongestSumbString();
		int i = ls
				.lengthOfLongestSubstring("");
		System.out.println(i);
	}

}
