package com.robin3;

import java.util.Stack;

public class SurrondedReigons {
	char[][] b;
	int hei, len;
	Stack<int[]> st = new Stack<int[]>();

	public void solve(char[][] board) {
		b = board;
		hei = board.length;
		if (hei == 0)
			return;
		len = b[0].length;
		for (int i = 0; i < hei; i++) {
			dfs(i, 0);
			dfs(i, len - 1);
		}
		for (int j = 0; j < len; j++) {
			dfs(0, j);
			dfs(hei - 1, j);
		}
		for (int i = 0; i < hei; i++)
			for (int j = 0; j < len; j++) {
				if (b[i][j] == 'O')
					b[i][j] = 'X';
				if (b[i][j] == 'Q')
					b[i][j] = 'O';
			}
	}

	public void dfs(int i, int j) {
		int[] in = new int[2];
		in[0] = i;
		in[1] = j;
		st.push(in);
		while (st.size() > 0) {
			int[] head = st.pop();
			b[head[0]][head[1]] = 'Q';
			add(head[0] - 1, head[1]);
			add(head[0] + 1, head[1]);
			add(head[0] - 1, head[1] + 1);
			add(head[0] - 1, head[1] - 1);
		}
	}

	public void add(int i, int j) {
		if (i < 0 || j < 0 || i >= hei || j >= len)
			return;
		if (b[i][j] != 'O')
			return;
		st.push(new int[] { i, j });
	}
}
