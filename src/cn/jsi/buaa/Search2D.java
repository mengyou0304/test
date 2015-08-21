package cn.jsi.buaa;

public class Search2D {
	 int[][] m;
	    int height;
	    int len;
	    int t;
	    public boolean b1(int h1,int l1,int h2,int l2){
	    	//System.out.printf("searching...[%d,%d](%d) to [%d,%d](%d)\n",h1,l1,m[h1][l1],h2,l2,m[h2][l2]);
	        int oh=h1;
	        int eh=h2;
	        int ol=l1;
	        int el=l2;
	        if(t<m[h1][l1]||t>m[h2][l2])
	            return false;
	        if(t==m[h1][l1]||t==m[h2][l2])
	            return true;
	        if(h2-h1<=1&&l2-l1<=1){
	            if(t!=m[h1][l1]&&t!=m[h1][l2]&&t!=m[h2][l1]&&t!=m[h2][l2]){
	            	//System.out.println("small sq false");
	                return false;
	            }
	            else{
	             //	System.out.println("small sq true");
	 	            return true;
	            }
	        }
	        int mh,ml;
	        int v;
	        while(true){
	            mh=(h1+h2)/2;
	            ml=(l1+l2)/2;
	            v=m[mh][ml];
	            if(v==t)
	                return true;
	            if(h2-h1<=1&&l2-l1<=1){
	            //	System.out.printf(" locate at [%d,%d](%d)~ [%d,%d](%d)\n\n",h1,l1,m[h1][l1],h2,l2,m[h2][l2]);
	                if(b1(h2,ol,eh,l1)||b1(oh,l2,h1,el))
	                    return true;
	                else
	                    return false;
	            }
	            if(v>t){
	                h2=mh;
	                l2=ml;
	            }
	            if(v<t){
	                h1=mh;
	                l1=ml;
	            }
	        }
	       
	    }
	    public boolean searchMatrix(int[][] matrix, int target) {
	        m=matrix;
	        t=target;
	        height=m.length;
	        if(height==0)
	            return false;
	        len=m[0].length;
	        return b1(0,0,height-1,len-1);
	    }
    public static void main(String[] args) {
    	Search2D s=new Search2D();
    	int base=10;
    	int[][] m=new int[9][];
    	for(int i=0;i<9;i++){
    		m[i]=new int[10];
    		for(int j=0;j<10;j++)
    			m[i][j]=base+j;
    		base+=10;
    	}
    	for(int[] ss:m){
    		for(int i:ss)
    			System.out.print(i+" ");
    		System.out.println();
    	}
    //	System.out.println(m);
    	int value=28;
    	System.out.println("finding   "+value);
    	boolean b=s.searchMatrix(m, value);
    	System.out.println(b);
	}
    

}
