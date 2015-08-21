package cn.jsi.buaa;

public class RoteImage {
	int[][] m;
    int n;
    public void rotateFourPoint(int x, int y){
        int tmp;
        int x1=n-y,y1=x;
        int x2=n-x,y2=n-y;
        int x3=y,y3=n-x;
//        System.out.println(y+","+x+"  "+m[y][x]);
//        System.out.println(y1+","+x1+"  "+m[y1][x1]);
//        System.out.println(y2+","+x2+"  "+m[y2][x2]);
//        System.out.println(y3+","+x3+"  "+m[y3][x3]);
//        System.out.println();
        
        tmp=m[y][x];
        m[y][x]=m[y3][x3];
        m[y3][x3]=m[y2][x2];
        m[y2][x2]=m[y1][x1];
        m[y1][x1]=tmp;
    }
    
    public void rotate(int[][] matrix) {
        n=matrix.length;
        m=matrix;
        if(n==0)
            return;
        int  n2;
        if(n%2==0){
            n2=n/2-1;
            n--;
            for(int x=0;x<=n2;x++)
            for(int y=0;y<=n2;y++){
                rotateFourPoint(x,y);
            }
        }else{
            n2=n/2;
            n--;
            for(int x=0;x<=n2;x++)
            for(int y=0;y<n2;y++){
                rotateFourPoint(x,y);
            }
        }
    }
    public static void main(String[] args) {
		int[][] m=new int[][]{new int[]{1,2,3},new int[]{4,5,6},new int[]{7,8,9}};
	//	m=new int[][]{new int[]{1,2},new int[]{3,4}};
		RoteImage r=new RoteImage();
		r.rotate(m);
		for(int[] s:m){
			for(int k:s)
				System.out.print(k+" ");
			System.out.println();
		}
		
	}

}
