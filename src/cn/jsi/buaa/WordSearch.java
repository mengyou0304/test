package cn.jsi.buaa;

public class WordSearch {
	int[] dx=new int[4];
    int[] dy=new int[4];
    char[][] b;
    byte[][] m;
    char[] s;
    int slen;
    int len;
    int wed;
    public boolean dp(int x,int y,int step,int cant){
    	//System.out.println(x+","+y);
        if(step==slen-1&&b[x][y]==s[step])
            return true;
        if(step>=slen)
            return false;
        if(b[x][y]!=s[step])
            return false;
        m[x][y]=1;
        int ox=x;
        int oy=y;
        for(int i=0;i<4;i++){
            if(i==cant)
                continue;
            x=ox+dx[i];
            y=oy+dy[i];
            if(x<0||y<0||x>=len||y>=wed)
                continue;
            
            if(m[x][y]==0&&dp(x,y,step+1,3-i))
                return true;
            
        }
        m[ox][oy]=0;
        return false;   
    }
    public boolean exist(char[][] board, String word) {
        dx[0]=1;dy[0]=0;
        dx[1]=0;dy[1]=-1;
        dx[2]=0;dy[2]=1;
        dx[3]=-1;dy[3]=0;
        len=board.length;
        if(len==0)
            return false;
        wed=board[0].length;
        m=new byte[len][wed];
        s=word.toCharArray();
        slen=s.length;
        b=board;
        
        for(int i=0;i<len;i++)
            for(int j=0;j<wed;j++)
               if( dp(i,j,0,-1))
                    return true;
        return false;
    }
    public static void main(String[] args) {
    	char[][] b=new char[3][];
    	b[0]=new String("aaa").toCharArray();
    	b[1]=new String("aaa").toCharArray();
    	b[2]=new String("aaa").toCharArray();
    	WordSearch s=new WordSearch();
    	boolean boo=s.exist(b, new String("aaaaaaaaaa"));
    	System.out.println(boo);
	}

}
