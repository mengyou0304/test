package cn.jsi.buaa;

public class InterleavingString {
	char[] c3;
	char[] c2;
	char[] c1;
	int[][][] road;
	public boolean dfs(int p1, int p2, int p3) {
		if(road[p1][p2][p3]==1)
				return true;
		if(road[p1][p2][p3]==-1)
				return false;
		boolean b1 = false, b2 = false;
//		System.out.printf("%d %d %d  [%c],[%c]  [%c]\n", p1, p2, p3, c1[p1],
//				c2[p2], c3[p3]);
		if (p1 < c1.length && c1[p1] == c3[p3]) {
			if (p3 == c3.length - 1)
				return true;
			b1 = dfs(p1 + 1, p2, p3 + 1);
			if(b1){
				road[p1+1][p2][p3+1]=1;				
				return true;
			}else
				road[p1+1][p2][p3+1]=-1;
		}
		if (p2 < c2.length && c2[p2] == c3[p3]) {
			if (p3 == c3.length - 1)
				return true;
			b2 = dfs(p1, p2 + 1, p3 + 1);
			if(b2){
				road[p1][p2+1][p3+1]=1;				
				return true;
			}else
				road[p1][p2+1][p3+1]=-1;
		}
		
		return false;
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if ((s1.length() + s2.length()) != s3.length())
			return false;
		if (s1 == null || s1.length() == 0) {
			if (s2 != null && s2.equals(s3))
				return true;
			else
				return false;
		}
		if (s2 == null || s2.length() == 0) {
			if (s1 != null && s1.equals(s3))
				return true;
			else
				return false;
		}
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		c3 = s3.toCharArray();
		road=new int[s1.length()+1][s2.length()+1][s3.length()+1];
		return dfs(0, 0, 0);
	}

	// //////////////////
	public void showS(String s) {
		for (char c : s.toCharArray())
			System.out.print(c + " ");
		System.out.println();
		int i = 0;
		for (char c : s.toCharArray())
			System.out.print(i++ + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		InterleavingString s = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		s1="a";
		s2="b";
		s3="ab";
		System.out.println("s1");
		s.showS(s1);
		System.out.println("s2");
		s.showS(s2);
		System.out.println("s3");
		s.showS(s3);
		boolean b = s.isInterleave(s1, s2, s3);
		System.out.println(b);
	}

}
