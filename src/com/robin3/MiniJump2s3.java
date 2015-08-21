package com.robin3;

import java.util.Date;

public class MiniJump2s3 {

	public int jump(int[] A) {
		int len = A.length;
		// 第几步走到了哪里
		int[] minJumpFrom = new int[len];
		minJumpFrom[0] = len - 1;
		int res = 0;
		for (int i = len - 2; i >= 0; i--) {
			int end = A[i] + i;
			int j = 0;
			for (; j <= res; j++) {
				if (end >= minJumpFrom[j])
					break;
			}
			minJumpFrom[j + 1] = i;
			res = j + 1;
		}
		return res;
	}

	public int s2(int[] jp) {
		int st = 0;
		int ed = 0;
		int step = 0;
		for (int i = 0; i <= jp.length - 2; i++) {
			if (i > st) {
				st = ed;
				step++;
			}
			ed = Math.max(ed, jp[i] + i);
		}
		if (ed < jp.length - 1)
			return 0;
		return step;
	}

	public static void main(String[] args) {
		MiniJump2s3 mj = new MiniJump2s3();

		int[] nums = new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 4 };
		// nums = new int[] { 1,2 };

		int res = mj.s2(nums);
		System.out.println(res);
	}

}
