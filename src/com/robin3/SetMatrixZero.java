package com.robin3;

public class SetMatrixZero {
	public void setZeroes(int[][] m) {
        int height=m.length;
        if(height==0)
            return;
        int len=m[0].length;
        boolean zeroi0=false;
        boolean zero0j=false;
        for(int j=0;j<len;j++)
            if(m[0][j]==0){
                zeroi0=true;
                break;
            }
            
        for(int i=0;i<height;i++)
            if(m[i][0]==0){
                zero0j=true;
                break;
            }
        for(int i=0;i<height;i++)
            for(int j=0;j<len;j++){
                if(m[i][j]==0){
                    m[i][0]=0;
                    m[0][j]=0;
                }
            }
        for(int i=1;i<height;i++)
            for(int j=1;j<len;j++)
                if(m[i][0]==0||m[0][j]==0)
                    m[i][j]=0;
        if(zeroi0)
            for(int j=0;j<len;j++)
                m[0][j]=0;
        if(zero0j)
            for(int i=0;i<height;i++)
                m[i][0]=0;
    }

}
