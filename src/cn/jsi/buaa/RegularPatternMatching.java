package cn.jsi.buaa;

import java.util.ArrayList;

public class RegularPatternMatching {
	

	public static void main(String[] args) {
		RegularPatternMatching rpm = new RegularPatternMatching();
		 System.out.println(rpm.isMatch("ab", ".*c"));
//		 System.out.println(rpm.isMatch("a", "ab"));
//		 System.out.println(rpm.isMatch("ac", "ab"));
//		 System.out.println(rpm.isMatch("ab.", "abc"));
//		 System.out.println(rpm.isMatch("ab.d", "abcd"));
//		 System.out.println(rpm.isMatch("a*b", "b"));
//		System.out.println(rpm.isMatch("a*b", "aaaaaabc"));
//		 System.out.println(rpm.isMatch("a*b", "aaab"));
//		 System.out.println(rpm.isMatch("a*b", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"));
	}

	int mat[][];
	int len1, len2;
	char[] s1, s2;
//	ArrayList<String> dppath = new ArrayList<String>();
//	private void debugMem() {
//		for (int i = 0; i < dppath.size(); i++) {
//			String s = dppath.get(i);
//			String[] ss = s.split(",");
//			int v = mat[Integer.parseInt(ss[0])][Integer.parseInt(ss[1])];
//			System.out.println("DP " + s + "= " + v);
//		}
//
//	}

	public boolean eq(char a1, char a2) {
		if (a1 != a2 && a1 != '.' && a2 != '.')
			return false;
		return true;
	}

	public boolean dp(int l1, int l2) {
//		dppath.add("" + l1 + "," + l2);
	//	System.out.println("dp" + l1 + " " + l2);
//		if (l1 == 2 && l2 == 1)
//			System.out.println();
		if (l1 >= len1 && l2 >= len2)
			return true;
		if (mat[l1][l2] != 0) {
			if (mat[l1][l2] < 0)
				return false;
			else
				return true;
		}
		// one line end, use * to end another line
		if (l1 == len1 && l2 + 2 < len2 && s2[l2 + 2] == '*') {
			boolean b = dp(l1, l2 + 2);
			if (b) {
				mat[l1][l2] = 1;
				return true;
			}
			mat[l1][l2] = -1;
			return false;
		}
		if (l2 == len2 && l1 + 2 < len1 && s1[l1 + 2] == '*') {
			boolean b = dp(l1 + 2, l2);
			if (b) {
				mat[l1][l2] = 1;
				return true;
			}
			mat[l1][l2] = -1;
			return false;
		}
		//judge if  have * in +1
		if (l1 + 1 < len1 && s1[l1 + 1] == '*') {
			l2--;
			do {
				l2++;
				boolean b = dp(l1 + 2, l2);
				if (b) {
					mat[l1][l2] = 1;
					return true;
				}
			} while (l2<len2&&(eq(s2[l2], s1[l1]) || s2[l2] == '*'));
		}
		if (l2 + 1 < len2 && s2[l2 + 1] == '*') {
			l1--;
			do {
				l1++;
				boolean b = dp(l1, l2 + 2);
				if (b) {
					mat[l1][l2] = 1;
					return true;
				}
			} while (l1<len1&&(eq(s2[l2], s1[l1]) || s1[l1] == '*'));
		}
		if (l1 < len1 && l2 < len2) {
			if (!eq(s1[l1], s2[l2])) {
				mat[l1][l2] = -1;
				return false;
			} else {
				boolean b = dp(l1 + 1, l2 + 1);
				if (b) {
					mat[l1][l2] = 1;
					return true;
				}
				
			}
		}
		mat[l1][l2] = -1;
		return false;
	}

	public boolean isMatch(String s, String p) {
		len1 = s.length();
		len2 = p.length();
		s1 = s.toCharArray();
		s2 = p.toCharArray();
		mat = new int[s.length() + 1][p.length() + 1];
		boolean b = dp(0, 0);
	//	debugMem();
		return b;
	}

}
