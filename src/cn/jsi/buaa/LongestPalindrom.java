package cn.jsi.buaa;

public class LongestPalindrom {
	int[][] m;
    char[] cc;
    int len;
    int maxlen=-1;
    String ss;
    String maxs;
    int count1=0;
    int count2=0;
    public boolean dp(int x,int y){
    	// System.out.printf("[%d] [%d] maxlen=%d   cc[x]=%c cc[y]=%c \n",x,y,maxlen,cc[x],cc[y]);
    	if(m[x][y]==1)
            return true;
        if(m[x][y]==-1)
            return false;
        count1++;
        if(cc[x]!=cc[y]){
    		m[x][y]=-1;
    		return false;
    	}
        count2++;
        if(x==y||y-x==1){
            m[x][y]=1;
            if(maxlen<y-x){
                maxlen=y-x;
                maxs=ss.substring(x,y+1);
            }
            return true;
        }
        if(x<y&&dp(x+1,y-1)){
            m[x][y]=1;
            if(maxlen<y-x){
                maxlen=y-x;
                maxs=ss.substring(x,y+1);
            }
            return true;
        }
        m[x][y]=-1;
        return false;
    }
    public String longestPalindrome(String s) {
        cc=s.toCharArray();
        ss=s;
        len=cc.length;
        m=new int[len+1][len+1];
    //    dp(0,len-1);
        for(int i=0;i<len;i++)
        	for(int j=len-1;j>=i;j--){
        		if(j-i<=maxlen)
        			continue;
        //		System.out.println("call  "+i+"/"+j+"  maxlen="+maxlen);
        		dp(i,j);
        	}
        return maxs;
    }
    public static void main(String[] args) {
    	LongestPalindrom lp=new LongestPalindrom();
    	String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    	//s="aaaaaa";
    	System.out.println(s.length());
    	String s2=lp.longestPalindrome(s);
    	System.out.println(s2);
    	System.out.println(s2.length());
    	System.out.println(lp.count1+"/"+lp.count2);
	}

}
