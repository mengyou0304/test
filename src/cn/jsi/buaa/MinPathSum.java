package cn.jsi.buaa;

public class MinPathSum {

	int [][] n;
    int [][] min;
    public int dp(){
        for(int i=n.length-1;i>=0;i--){
            for(int j=n[0].length-1;j>=0;j--){
                if(i==n.length-1&&j==n[0].length-1){
                    min[i][j]=n[i][j];
                    continue;
                }
                if(i==n.length-1){
                    min[i][j]=min[i][j+1]+n[i][j];
                    continue;
                }
                if(j==n[0].length-1){
                    min[i][j]=min[i+1][j]+n[i][j];
                    continue;
                }
                min[i][j]=Math.min(min[i+1][j],min[i][j+1])+n[i][j];
            }
        }
        return min[0][0];
    }
    public int minPathSum(int[][] grid) {
        if(grid.length<1)
            return 0;
        n=grid;
        min=new int[grid.length][grid[0].length];
        return dp();
    }
    public static void main(String[] args) {
    	MinPathSum m=new MinPathSum();
    	int[][] s=new int[][]{new int[]{0}};
    	System.out.println(m.minPathSum(s));
	}
}
