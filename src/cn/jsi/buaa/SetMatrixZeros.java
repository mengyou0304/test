package cn.jsi.buaa;

public class SetMatrixZeros {
	public void setZeroes(int[][] matrix) {
        int len=matrix.length;
        int wed=0;
        if(len==0)
            return;
        else
            wed=matrix[0].length;
        int zx=-1,zy=-1;
        boolean firsttime=true;
        for(int i=0;i<len;i++){
            for(int j=0;j<wed;j++){
                if(firsttime&&matrix[i][j]==0){
                    zx=i;
                    zy=j;
                    firsttime=false;
                }
                if(!firsttime&&matrix[i][j]==0){
                    matrix[zx][j]=0;
                    matrix[i][zy]=0;
                }
            }
        }
        if(zx==-1)
        	return;
        for(int i=0;i<len;i++){
        	if(i==zx)
                continue;
        //	System.out.println("i="+i);
            if(matrix[i][zy]==0)
                for(int j=0;j<wed;j++)
                    matrix[i][j]=0;
        }
        for(int j=0;j<wed;j++){
        //	System.out.println("j="+j+" zx="+zx+" m[][]="+matrix[zx][j]);
            if(matrix[zx][j]==0)
                for(int i=0;i<len;i++){
                    matrix[i][j]=0;
                }
            else
            	matrix[zx][j]=0;
        }
        
    }
	public static void main(String[] args) {
		SetMatrixZeros m=new SetMatrixZeros();
		m.setZeroes(new int[][]{new int[]{0,1}});
	}
}
