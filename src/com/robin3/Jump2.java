package com.robin3;

public class Jump2 {
	int[] minj;
    public int jump(int[] jmp) {
        minj=new int[jmp.length+1];
        for(int i=0;i<minj.length;i++)
            minj[i]=jmp.length;
        minj[jmp.length-1]=0;
        for(int i=jmp.length-2;i>=0;i--){
    		if(i+jmp[i]>=jmp.length-1){
    			minj[i]=1;
    			continue;
    		}
            for(int j=i+jmp[i];j>=i;j--)
                minj[i]=Math.min(minj[i],minj[j]);          
            minj[i]++;
        }
        return minj[0];
    }
    public static void main(String[] args) {
    		Jump2 j=new Jump2();
    		j.jump(new int[]{});
	}

}
