package cn.jsi.buaa;

public class DistinctSubSeq {
	//long
    char[] cs;
    //short
    char[] ts;
    public int numDistinct(String S, String T) {
        cs=S.toCharArray();
        ts=T.toCharArray();
        int len1=cs.length-1;
        int len2=ts.length-1;
        int[][] l=new int[len2+1][len1+1];
        for(int j=0;j<cs.length;j++){
            char c=cs[len1-j];
            for(int i=0;i<ts.length;i++){
            	char m=ts[len2-i];
                if(m==c){
                    if(i==0&&j==0){
                        l[i][j]=1;
                        continue;    
                    }
                    if(i==0){
                        l[i][j]=l[i][j-1]+1;
                        continue;
                    }
                    if(j==0)
                        continue;
                    l[i][j]=l[i-1][j-1]+l[i][j-1];
                }else{
                    if(j==0)
                        continue;
                    l[i][j]=l[i][j-1];
                }
            }
        }
        return l[len2][len1];
    }
    public static void main(String[] args) {
    	DistinctSubSeq ds=new DistinctSubSeq();
    	int v=ds.numDistinct("ababcc", "abbc");
    	System.out.println(v);
	}
}
