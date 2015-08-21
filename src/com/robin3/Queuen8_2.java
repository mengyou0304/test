package com.robin3;

public class Queuen8_2 {
	int num=0;
	int mask=0;
    public int totalNQueens(int n) {
    		mask=(1<<(n))-1;
    		System.out.println(mask);
        dp(1,0,0,0,n);
        return num;
    }
    public void dp(int p,int line,int up,int down,int n){
        if(p>n){
            num++;
            return;
        }
        int x=mask&(~(line|up|down));
        while(x!=0){
            int sel=x&-x;
            x-=sel;
            dp(p+1,line|sel,(up|sel)>>1,(down|sel)<<1,n);
        }
    }
    public static void main(String[] args) {
    		Queuen8_2 q=new Queuen8_2();
    		System.out.println(q.totalNQueens(2));
	}

}
