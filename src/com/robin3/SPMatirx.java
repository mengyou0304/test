package com.robin3;

import java.util.ArrayList;
import java.util.List;

import com.robin3.utility.DataGen2;

public class SPMatirx {
	public List<Integer> spiralOrder(int[][] m) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int height = m.length;
		if (height == 0)
			return list;
		int len = m[0].length;
		boolean[][] tr = new boolean[height][len];
		int[] dx = new int[4];
		int[] dy = new int[4];
		dx[0] = 1;
		dy[0] = 0;
		dx[1] = 0;
		dy[1] = 1;
		dx[2] = -1;
		dy[2] = 0;
		dx[3] = 0;
		dy[3] = -1;
		int step = 1;
		int direct = 0;
		int x = 0;
		int y = 0;
		list.add(m[0][0]);
		tr[0][0]=true;
		while (true) {
			int nx = x + dx[direct];
			int ny = y + dy[direct];
			if ((nx < len && nx >= 0 && ny < height && ny >= 0 && !tr[ny][nx])) {
				step++;
				list.add(m[ny][nx]);
				tr[ny][nx] = true;
				x = nx;
				y = ny;
			} else {
				direct = (direct + 1) % 4;
			}
			if(step>=len*height){
				break;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SPMatirx sm = new SPMatirx();
		int[][] nums = new int[3][];
		nums[0] = new int[] { 1, 2, 3 };
		nums[1] = new int[] { 4, 5, 6 };
		nums[2] = new int[] { 7, 8, 9 };
		nums=new int[1][];
		nums[0]=new int[]{1};
		DataGen2.ShowL(sm.spiralOrder(nums));
	}

}
