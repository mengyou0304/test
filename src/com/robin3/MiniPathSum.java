package com.robin3;

public class MiniPathSum {
	 public int minPathSum(int[][] grid) {
	        int height=grid.length;
	        if(height==0)
	            return 0;
	        int len=grid[0].length;
	        int[][] minv=new int[height][len];
	        for(int i=0;i<height;i++){
	            for(int j=0;j<len;j++){
	                int upv=Integer.MAX_VALUE;
	                int leftv=Integer.MAX_VALUE;
	                if(i-1>=0)
	                    upv=minv[i-1][j];
	                if(j-1>=0)
	                    leftv=minv[i][j-1];
	                minv[i][j]=Math.min(leftv,upv)+grid[i][j];
	                if(i==0&&j==0)
	                    minv[i][j]=grid[i][j];
	            }
	        }
	        return minv[height-1][len-1];
	    }

}
