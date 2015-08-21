package com.robin3;

public class ScrambleString  {
	char[] cc1,cc2;
    int[][][] same;
    public boolean isScramble(String s1, String s2) {
        cc1=s1.toCharArray();
        cc2=s2.toCharArray();
        if(cc1.length!=cc2.length)
            return false;
        same=new int[cc1.length+5][cc2.length+5][cc1.length+5];
        return dp(0,cc1.length-1,0);
    }
    public boolean dp(int start1,int end1,int start2){
    	System.out.println("dp:"+start1+" "+end1+" "+start2);
        if(end1<start1)
            return false;
        if(end1==start1)
        	if(cc1[start1]==cc2[start2])
        		return true;
        	else
        		return false;
        if(same[start1][end1][start2]==1)
            return true;
        if(same[start1][end1][start2]==-1)
            return false;
        for(int i=start1;i<end1;i++){
            if((dp(start1,i,start2)&&dp(i+1,end1,i-start1+start2+1))||(dp(i+1,end1,start2)&&dp(start1,i,end1+start2-i))){
                same[start1][end1][start2]=1;
            	System.out.println("setting:"+start1+" "+end1+" "+start2+"   as 1");
                return true;
            }
        }
        same[start1][end1][start2]=-1;
        System.out.println("setting:"+start1+" "+end1+" "+start2+"   as -1");
        return false;
    }
    public static void main(String[] args) {
    	ScrambleString ss=new ScrambleString();
    	System.out.println(ss.isScramble("aa", "aa"));
	}

}
