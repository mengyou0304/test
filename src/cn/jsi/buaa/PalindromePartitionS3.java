package cn.jsi.buaa;

public class PalindromePartitionS3 {
	char[] cc;
	int len;
	int[] count;
	int[][] isp;

	public boolean jisp(int start, int end) {
		if (isp[start][end] == -1)
			return false;
		if (isp[start][end] == 1)
			return true;
		int ost = start;
		int oed = end;
		Boolean res = null;
		while (start <= end) {
			if (cc[start] == cc[end]) {
				if (end - start <= 1) {
					res = true;
					break;
				}
				if (isp[start + 1][end - 1] == 1) {
					res = true;
					break;
				}

			} else {
				res = false;
				break;
			}
			start++;
			end--;
		}
		if (res)
			while (ost <= start) {
				isp[start][end] = 1;
				start--;
				end++;
			}
		if (!res)
			while (ost <= start) {
				isp[start][end] = -1;
				start--;
				end++;
			}
		return res;
	}

	public int dp(int start) {
		if (count[start] != 0)
			return count[start];
		if (start >= len)
			return 0;
		int currentC = Integer.MAX_VALUE;
		for (int i = len - 1; i >= start; i--)
			if (isp[start][i] == 1 || jisp(start, i)) {
				int son = dp(i + 1);
				if (currentC > son + 1)
					currentC = son + 1;
			}
		count[start] = currentC;
		return count[start];
	}

	public int minCut(String s) {
		cc = s.toCharArray();
		len = cc.length;
		count = new int[len + 3];
		isp = new int[len][len];
		return dp(0) - 1;
	}

	public static void main(String[] args) {
		PalindromePartitionS3 p = new PalindromePartitionS3();
		// System.out.println(p.minCut("bbbbbbbbbbbbbbbb"));
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// s =
		// "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		// s = "aaaabcc";
		System.out.println("s.length=" + s.length());
		System.out.println(p.minCut(s));

	}

}
