package cn.jsi.buaa;

import java.util.ArrayList;

public class SprialMatrix {
	int height;
    int len;
    int[][] m;
    int[][] n;
    int[] dx=new int[4];
    int[] dy=new int[4];
    ArrayList<Integer> reslist=new ArrayList<Integer>();
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        m=matrix;
        height=m.length;
        if(height==0)
            return reslist;
        len=m[0].length;
        dx[0]=0;dy[0]=1;
        dx[1]=1;dy[1]=0;
        dx[2]=0;dy[2]=-1;
        dx[3]=-1;dy[3]=0;
        n=new int[height][len];
        int v=1;
        int d=0;
        int x=0,y=0;
        reslist.add(m[0][0]);
        int max=height*len;
        while(v<=max){
            n[x][y]=v++;
            x=x+dx[d];
            y=y+dy[d];
            if(x<0||x>=height||y<0||y>=len||n[x][y]!=0){
                x=x-dx[d];
                y=y-dy[d];
                d=(d+1)%4;
                x+=dx[d];
                y+=dy[d];
            }
            if(x<0||x>=height||y<0||y>=len||n[x][y]!=0)
            	break;
            reslist.add(m[x][y]);
        }
       // reslist.remove(reslist.size()-1);
        return reslist;
    }
    public static void main(String[] args) {
    	SprialMatrix sm=new SprialMatrix();
    	int n=1;
    	int v=1;
    	int[][] m=new int[n][n];
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			m[i][j]=v++;
    			System.out.print(m[i][j]+" ");
    		}
    		System.out.println();
    	}
    	m=new int[1][2];
    	m[0][0]=2;
    	m[0][1]=3;
    	ArrayList<Integer> list=sm.spiralOrder(m);
    	System.out.println("res: ");
    	System.out.println(list);
    	
    	
	}

}
