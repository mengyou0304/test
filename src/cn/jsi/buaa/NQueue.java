package cn.jsi.buaa;

import java.util.ArrayList;

public class NQueue {

	ArrayList<String[]> res=new ArrayList<String[]>();
    int n;
    int[][] pos;
    public void debugP(){
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			if(pos[i][j]==-1)
    				System.out.print("* ");
    			else
    				System.out.print(pos[i][j]+ " ");
    		}
    		System.out.println();
    	}
    }
    public void ocupy(int x,int y){
        pos[y][x]=-1;
        if(x>=n)
        	return;
        for(int i=x+1;i<n;i++){
            pos[y][i]++;
            if(y+i-x<n)
              pos[y+(i-x)][i]++;
            if(y-i+x>=0)
              pos[y-(i-x)][i]++;
        }
    }
    public void back(int x,int y){
          pos[y][x]=0;
          if(x>=n)
          	return;
         for(int i=x+1;i<n;i++){
            pos[y][i]--;
            if(y+i-x<n)
              pos[y+(i-x)][i]--;
            if(y-i+x>=0)
              pos[y-(i-x)][i]--;
        }
    }
    public boolean canOcupy(int x,int y){
        if(pos[y][x]==0)
            return true;
        return false;
    }
    public void genRes(){
        String[] ss=new String[n];
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++){
                if(pos[i][j]==-1)
                    s+="Q";
                else
                    s+=".";
            }
            ss[i]=s;
        }
        res.add(ss);
    }
    public void dp(int x){
    //	System.out.println("dp"+x);
        if(x==n){
            genRes();
         //   debugP();
            return;
        }
        for(int i=0;i<n;i++){
            if(!canOcupy(x,i))
                continue;
            ocupy(x,i);
            dp(x+1);
            back(x,i);
        }
        
    }
    public ArrayList<String[]> solveNQueens(int num) {
        if(num==0)
            return res;
        pos=new int[num+1][num+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++)
                pos[i][j]=0;
        n=num;
        dp(0);
        return res;
    }
    public static void main(String[] args) {
    	NQueue n=new NQueue();
    	ArrayList<String[]> res=n.solveNQueens(8);
    	System.out.println("number="+res.size());
	}
}
