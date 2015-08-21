package cn.jsi.buaa;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePartitioning2 {
	int len;
	char[] ins;
	int[] pres;
	int[][] isp;
	int[][] conunted;
	int minilen = 0x0FFFFFFF;
	String os;

	public boolean isPa(int start, int end) {
		boolean res = true;
		int ost = start;
		if (end < start)
			return false;
		while (start <= end) {
			if (isp[start][end] == 1) {
				res = true;
				break;
			}
			if (ins[start] != ins[end]) {
				res = false;
				break;
			}
			start++;
			end--;
		}
		if (!res)
			return res;

		while (start <= ost) {
			System.out.println("start=" + start + "  end=" + end);
			isp[start][end] = 1;
			start--;
			end++;
		}
		return res;
	}

	public int dp2() {
		int res = 0;
		int[] ts = new int[len + 1];
		ts[len] = 1;
		for (int i = len - 1; i >= 0; i--)
			for (int j = i; j < len; j++)
				if (isPa(i, j))
					ts[i] += ts[j + 1];

		return ts[0];

	}

	public void dp3(int start, int currentlen) {
		if(conunted[start][currentlen]==1)
				return;
		conunted[start][currentlen]=1;
		if (start >= len) {
			if (currentlen < minilen)
				minilen = currentlen;
		}
		if (currentlen > minilen)
			return;
		for (int i = len - 1; i >= start; i--) {
			if (isp[start][i] == 1 || isPa(start, i)) {
				dp3(i + 1, currentlen + 1);
			}
		}

	}

	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;
		len = s.length();
		isp = new int[len][len];
		conunted=new int[len+1][0xfff];
		ins = s.toCharArray();
		os = s;
		dp3(0, 0);
		return minilen - 1;

	}

	private void debugPres() {
		for (int i = 0; i < len; i++)
			System.out.println(i + " : " + pres[i]);

	}

	public static void main(String[] args) {
		PalindromePartitioning2 p = new PalindromePartitioning2();
		// System.out.println(p.minCut("bbbbbbbbbbbbbbbb"));
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//s = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
		//s = "bbbbbbbaba";
		System.out.println("s.length=" + s.length());
		System.out.println(p.minCut(s));

	}

}
