package cn.jsi.buaa;

public class SearchRange {
	int[] res = new int[2];
	int[] a;
	int minv=Integer.MAX_VALUE;
	int maxv=-1;
	int t;

	public void gb(int si, int ei) {
		//System.out.println("Searching..."+si+"   "+ei);
		if (si > ei || a[ei] < t || a[si] > t)
			return;
	//	System.out.println("Go in minv="+minv);
		if (si < minv && a[si] == t) {
		//	System.out.println("Update minv");
			minv = si;
		}
		if (ei > maxv && a[ei] == t) {
			maxv = ei;
		}
		if (si == ei)
			return;
		int m = (si + ei) / 2;
		gb(si, m);
		gb(m + 1, ei);

	}

	public int[] searchRange(int[] A, int target) {
		a = A;
		t = target;
		res[0] = -1;
		res[1] = -1;
		gb(0, a.length - 1);
		if(minv==Integer.MAX_VALUE)
			minv=-1;
		res[0] = minv;
		res[1] = maxv;
		return res;
	}

	public static void main(String[] args) {
		SearchRange sr = new SearchRange();
		int[] se = new int[] { 5, 7, 7, 8, 8, 9 };
		int[] s = sr.searchRange(se, 7);
		for (int i : se) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < se.length; i++)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("[" + s[0] + "," + s[1] + "]");
	}
}
