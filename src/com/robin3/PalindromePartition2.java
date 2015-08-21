package com.robin3;

public class PalindromePartition2 {
	char[] cc;
    int[][] rec;
    int minc;
    public int minCut(String s) {
        cc=s.toCharArray();
        rec=new int[cc.length+5][cc.length+5];
        for(int i=cc.length-1;i>=0;i--)
            for(int j=i;j<cc.length;j++)
                if(cc[i]==cc[j]&&(j-i<2||rec[i+1][j-1]==1))
                    rec[i][j]=1;
        minc=Integer.MAX_VALUE;
        dp(0,0);
        return minc;
    }
    public void dp(int p,int cut){
        if(cut>=minc)
            return;
        if(p>=cc.length){
            minc=cut;
            return;
        }
        for(int i=cc.length-1;i>=p;i--)
            if(rec[p][i]==1)
                dp(i+1,cut+1);
    }
    public static void main(String[] args) {
    	PalindromePartition2 pp2=new PalindromePartition2();
    	int v=pp2.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi");
    	System.out.println(v);
	}

}
