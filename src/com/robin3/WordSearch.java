package com.robin3;

public class WordSearch {
	char[] cc;
	int[] dx = new int[4];
	int[] dy = new int[4];
	byte[][][] record;
	boolean[][] tr;

	public boolean exist(char[][] board, String word) {
		cc = word.toCharArray();
		dx[0] = 0;
		dy[0] = 1;
		dx[1] = 0;
		dy[1] = -1;
		dx[2] = 1;
		dy[2] = 0;
		dx[3] = -1;
		dy[3] = 0;
		int height = board.length;
		if (height == 0)
			return false;
		int len = board[0].length;
		record = new byte[height][len][cc.length];
		tr = new boolean[height][len];
		for (int y = 0; y < height; y++)
			for (int x = 0; x < len; x++)
				if (dp(y, x, -1, height, len, board))
					return true;
		return false;
	}

	public boolean dp(int oy, int ox, int cr, int height, int len, char[][] b) {
		if (record[height][len][cr] == -1)
			return false;
		for (int i = 0; i < 4; i++) {
			int nx = ox + dx[i];
			int ny = oy + dy[i];
			if (ny >= 0 && ny < height && nx >= 0 && nx < len && !tr[nx][ny]
					&& b[ny][nx] == cc[cr + 1]) {
				tr[nx][ny] = true;
				if (dp(ny, nx, cr + 1, height, len, b))
					return true;
				tr[nx][ny] = false;
			}
		}
		record[height][len][cr] = -1;
		return false;
	}

}
