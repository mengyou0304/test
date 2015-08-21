package cn.jsi.buaa;

public class EditDistance {

	char[] w1;
    char[] w2;
    int[][] dis;
    int len1;
    int len2;
    public int dp(int s1,int s2){
        if(dis[s1][s2]!=-1){
            return dis[s1][s2];
        }
        if(s1>=len1){
       		return len2-s2;
        }
        if(s2>=len2){
       		return len1-s1;
        }
        if(w1[s1]==w2[s2])
            return dp(s1+1,s2+1);
        //right goes one ->+
        int v1=dp(s1,s2+1);
        //left goes one --
        int v2=dp(s1+1,s2);
    //    System.out.println("v1="+v1+" v2="+v2+"  balence="+balence);
        int v3=dp(s1+1,s2+1);
        int min=Integer.MAX_VALUE;
        if(min>v1)
        	min=v1;
        if(min>v2)
        	min=v2;
        if(min>v3)
        	min=v3;
        min++;
      //  System.out.println("setting...dis["+s1+"]["+s2+"]="+min);
        dis[s1][s2]=min;
        return min;
    }
    public int minDistance(String word1, String word2) {
        w1=word1.toCharArray();
        w2=word2.toCharArray();
        len1=w1.length;
        len2=w2.length;
//        if(len1==len2&&len1==1)
//        		return 1;
        	
        dis=new int[w1.length+1][w2.length+1];
        for(int i=0;i<=w1.length;i++)
            for(int j=0;j<=w2.length;j++)
                dis[i][j]=-1;
        int v=dp(0,0);
        return v;
    }
    public static void main(String[] args) {
    	EditDistance ed=new EditDistance();
    	//int v=ed.minDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef", "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg");
    	int v=ed.minDistance("a","e");
    //	int v=ed.minDistance("a","b");
    	System.out.println(v);
    	
	}
}
