package com.robin3;

public class RotateImage {
	public void rotate(int[][] mm) {
        int n=mm.length;
        if(n<2)
            return;
        for(int y=n-1;y>=(n+1)/2;y--){
            for(int x=0+(n-y-1);x<y;x++){
                int v0=mm[x][y];
                int v1=mm[y][n-1-x];
                int v2=mm[n-1-x][n-1-y];
                int v3=mm[n-1-y][x];
                mm[y][n-1-x]=v0;
                mm[n-1-x][n-1-y]=v1;
                mm[n-1-y][x]=v2;
                mm[x][y]=v3;
            }
        }
    }
	public void show(int[][] v){
		for(int[] tv:v){
			for(int i:tv)
				System.out.print(i+",");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][]v=new int[3][];
		v[0]=new int[]{1,2,3};
		v[1]=new int[]{4,5,6};
		v[2]=new int[]{7,8,9};
		RotateImage ri=new RotateImage();
		ri.rotate(v);
		ri.show(v);
	}

}
