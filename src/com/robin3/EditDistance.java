package com.robin3;

public class EditDistance {
	int[][] minstep;
	char[] cc1, cc2;

	public int minDistance(String word1, String word2) {
		cc1 = word1.toCharArray();
		cc2 = word2.toCharArray();
		minstep = new int[cc1.length + 5][cc2.length + 5];
		for (int i = 0; i < cc1.length + 5; i++)
			for (int j = 0; j < cc2.length + 5; j++)
				minstep[i][j] = Integer.MAX_VALUE;
		return dp(0, 0);
	}

	public int dp(int i1, int i2) {
		if (i1 >= cc1.length)
			return cc2.length - i2;
		if (i2 >= cc2.length)
			return cc1.length - i1;
		if (minstep[i1][i2] != Integer.MAX_VALUE)
			return minstep[i1][i2];
		if (cc1[i1] == cc2[i2])
			return dp(i1+1,i2+1);
		int v1 = dp(i1, i2 + 1);
		v1 = Math.min(v1, dp(i1 + 1, i2));
		v1 = Math.min(v1, dp(i1 + 1, i2 + 1)) + 1;
		minstep[i1][i2] = v1;
		return v1;
	}

	public static void main(String[] args) {
		EditDistance ed = new EditDistance();
		int v=ed.minDistance("ab", "a");
		System.out.println(v);
	}

}
