package cn.jsi.buaa;

import java.util.Queue;
import java.util.Scanner;

public class InputTest {
	int[][] path;
    Integer[][] minw;
    int ll;
    int rl;
    int[] dx;
    int[] dy;   
    public boolean updateP(int x, int y){
        int w=minw[x][y];
        if(x+1<ll){
            int dw=w+path[x+1][y];
            if(minw[x+1][y]>0&&minw[x+1][y]>dw||minw[x+1][y]<0)
                minw[x+1][y]=dw;
        }
        if(y+1<rl){
          int rw=w+path[x][y+1];
          if(minw[x][y+1]>0&&minw[x][y+1]>rw||minw[x][y+1]<0)
              minw[x][y+1]=rw;
        }
        System.out.println("Updating "+x+y+"  "+minw[x][y]);
        return true;
    }
    public void badboy(){
        for(int i=0;i<ll;i++){
            for(int j=0;j<rl;j++){
                    updateP(i,j);
            }
        }
    }
    public void bfs(int x,int y,int w){
        // int nx,ny;
        // updateP(x,y);
        // for(int j=0;j<2;j++){
        //     nx=x+dx[j];
        //     ny=x+dy[j];
        //     bfs(nx,ny);
        // }
        
    }
    public int minPathSum(int[][] grid) {
        path=grid;
        ll=grid.length;
        if(ll==0)
            return 0;
        rl=grid[0].length;
        minw=new Integer[ll][rl];
        for(int i=0;i<ll;i++)
            for(int j=0;j<rl;j++)
                minw[i][j]=-1;
        dx=new int[2];
        dy=new int[2];
        dx[0]=1;dy[0]=0;
        dx[1]=0;dy[1]=1;
        minw[0][0]=path[0][0];
        badboy();
        return minw[ll-1][rl-1];
        
    }

	public static void main(String[] args) {
		InputTest t=new InputTest();
		int[][] grid=new int[][]{
				{1,2},{1,1}
		};
		int newg=t.minPathSum(grid);
		System.out.println(newg);
	}

}
