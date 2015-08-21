package cn.jsi.buaa;

public class SpirialMatrix2 {
	int[][] m;
	int[] dx=new int[4];
	int[] dy=new int[4];

	public int[][] generateMatrix(int n) {
		m = new int[n][n];
		int n2 = n * n;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				m[i][j] = 0;
		int x = 0;
		int y = 0;
		int direct = 0;
		dx[0] = 0;
		dy[0] = 1;
		dx[2] = 0;
		dy[2] = -1;
		dx[1] = 1;
		dy[1] = 0;
		dx[3] = -1;
		dy[3] = 0;
		int v = 1;
		while (v <= n2) {
			m[x][y] = v++;
			x = x + dx[direct];
			y = y + dy[direct];
			if (x < 0 || x >= n || y < 0 || y >= n || m[x][y] != 0){
				x=x-dx[direct];
				y=y-dy[direct];
				direct = (direct + 1) % 4;
				x = x + dx[direct];
				y = y + dy[direct];
			}
		}
		return m;
	}

	public static void main(String[] args) {
		SpirialMatrix2 sm = new SpirialMatrix2();
		int n=5;
		int[][] m=sm.generateMatrix(n);
		for(int[] m1:m){
			for(int m2: m1)
				System.out.print(m2+" ");
			System.out.println();
		}
	}

}
