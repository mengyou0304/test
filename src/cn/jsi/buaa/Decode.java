package cn.jsi.buaa;

public class Decode {
	char[] ss;
    int[] num;
    int len=0;
    //1:jump1
    //2: jump2
    //3: jump 1+2
    //-1 00
    //0 no jump1 or jump2
    public int validate(int p){
        if(ss[p]=='0'){
        	if(p-1>=0&&ss[p-1]=='0')
        		return -1;
        	if(p+1<len&&ss[p+1]=='0')
        		return -1;
            return 0;
        }
        if(ss[p]=='1'){
            return 3;
        }
        if(ss[p]=='2'){
        	if(p+1>=len)
        		return 1;
            if(ss[p+1]<'7')
                return 3;
            else;
                return 1;
        }
        return 1;
    }
    public int buildTree(int p){
        if(p>ss.length)
            return 0;
        if(p==ss.length)
        	return 1;
        if(num[p]!=-1)
            return num[p];
        int value=validate(p);
        System.out.println(" validate p="+p+" value="+value);
        
        int v1=0;
        int v2=0;
        if(value==-1)
            return -1;
        if(value==2||value==3)
            v2=buildTree(p+2);
        if(value==1||value==3)
            v1=buildTree(p+1);
        if(v1==-1||v2==-1)
            return -1;
        int all=v1+v2;
        num[p]=all;
        System.out.println("setting...num["+p+"]="+num[p]);
        return all;
    }
    public int numDecodings(String s) {
        ss=s.toCharArray();
        len=ss.length;
        if(len==0)
            return 0;
        num=new int[ss.length];
        for(int i=0;i<ss.length;i++)
            num[i]=-1;
        int v= buildTree(0);
            if(v==-1)
                return 0;
        return v;
    }
    public static void main(String[] args) {
    	Decode d=new Decode();
    	int v=d.numDecodings("1010");
    	System.out.println(v);
	}
}
