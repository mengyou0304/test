package cn.jsi.buaa;

import java.util.HashMap;
import java.util.HashSet;

public class SudukuSolver {
	char[][] b;
	boolean[][] hv = new boolean[9][9];
	boolean[][] lv = new boolean[9][9];
	boolean[][] bv = new boolean[9][9];

	// determin if it is a validate value;
	public boolean determine(int height, int len, char num) {
		for (int i = 0; i < 9; i++) {
			if (num == b[height][i] || num == b[i][len])
				return false;
		}
		int h = (height / 3) * 3;
		int l = (len / 3) * 3;
		for (int i = h; i < h + 3; i++)
			for (int j = l; j < l + 3; j++) {
				if (num == b[i][j])
					return false;
			}
		return true;
	}

	public boolean determine2(int i, int j, char num) {
		int c = b[i][j] - '1';
		if (hv[i][c])
			return false;
		if (lv[j][c])
			return false;
		int value = i / 3 + j / 3;
		if (bv[value][c])
			return false;
		return true;
	}
	public  void put(int i,int j,char num){
		int c = b[i][j] - '1';
		int value = i / 3 + j / 3;
	//	System.out.println("put"+i+" "+j+" "+num+" "+value+" "+c);
		bv[value]
				[c] = true;
		hv[i][c] = true;
		lv[j][c] = true;
	}
	public void remove(int i,int j,char num){
		int c = b[i][j] - '1';
		int value = i / 3 + j / 3;
		bv[value][c] = false;
		hv[i][c] = false;
		lv[j][c] = false;
	}

	public boolean dp(int height, int len, HashSet<Integer> valueset) {
		 System.out.println("tring.... "+height+"  "+len);
		if (len == 9) {
			valueset.clear();
			if (height == 8) {
				return true;
			}
			height++;
			len = 0;
		}
		if (b[height][len] != '.') {
			valueset.add(b[height][len] - '1');
			boolean isfinish = dp(height, len + 1, valueset);
			if (isfinish)
				return true;
			else
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (valueset.contains(i))
				continue;
			char c = (char) ('1' + i);
			// System.out.println("c="+c);
			if (!determine(height, len, c))
				continue;
			b[height][len] = c;
			put(height,len,c);
			
			valueset.add(i);
			boolean isfinish = dp(height, len + 1, valueset);
			if (isfinish)
				return true;
			valueset.remove(i);
			remove(height,len,c);
		}
		b[height][len] = '.';
		return false;
	}

	public boolean basicValidatin() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (b[i][j] == '.')
					continue;
				int c = b[i][j] - '1';
				if (hv[i][c])
					return false;
				hv[i][c] = true;
				if (lv[j][c])
					return false;
				lv[j][c] = true;
				int value = i / 3 + j / 3;
				if (bv[value][c])
					return false;
				bv[value][c] = true;
			}
		return true;
	}

	public boolean solveSudoku(char[][] board) {
		b = board;
		boolean b2 = basicValidatin();
		if (!b2)
			return false;
		HashSet<Integer> valueset = new HashSet<Integer>();
		boolean isfinish = dp(0, 0, valueset);
		// System.out.println(isfinish);
		return isfinish;
	}

	public static void main(String[] args) {
		String[] ss = new String[] { ".87654321","2........","3........","4........","5........","6........","7........","8........","9........" };
		SudukuSolver ins = new SudukuSolver();
		char[][] board = new char[9][9];
		int i = 0;
		for (String s : ss) {
			char[] cc = s.toCharArray();
			board[i++] = cc;
		}
		for (char[] cc : board) {
			for (char tc : cc)
				System.out.print(tc + " ");
			System.out.println();
		}
		boolean isfinish = ins.solveSudoku(board);
		System.out.println("isfinish=" + isfinish);
		for (char[] cc : board) {
			for (char tc : cc)
				System.out.print(tc + " ");
			System.out.println();
		}
	}

}
