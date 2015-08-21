package com.robin3;

public class SPMatirx2 {
	public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
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
	    int step=1;
	    int n2=n*n;
	    int x=0;
	    int y=0;
	    int direct=0;
	    while(step<=n2){
	        res[y][x]=step++;
	        if(step>n2)
	        		break;
	        int ny=y+dy[direct];
	        int nx=x+dx[direct];
	        while(ny<0||ny>=n||nx<0||nx>=n||res[ny][nx]!=0){
	            direct=(direct+1)%4;
	            ny=y+dy[direct];
	            nx=x+dx[direct];
	        }
	        y=ny;
	        x=nx;
	    }
	    return res;
    }
	public static void main(String[] args) {
		SPMatirx2 spm2=new SPMatirx2();
		int[][] res=spm2.generateMatrix(4);
		for(int[] is:res){
			for(int i:is){
				System.out.print(i+"\t");
			}
			System.out.println();
		}
	}

}
