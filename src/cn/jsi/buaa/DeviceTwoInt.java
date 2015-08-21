package cn.jsi.buaa;

public class DeviceTwoInt {
	public int divide(int dividend, int divisor) {
        long b=dividend;
        long c=divisor;
        if(b==0)
            return 0;
        if(c==0)
            return Integer.MAX_VALUE;
        int isneg=0;
        if(b<0){
            b=-b;
            isneg++;
        }
        if(c<0){
            c=-c;
            isneg++;
        }
        if(isneg==2)
            isneg=0;
        long sum=c;     
        long[] n=new long[100];
        long[] m=new long[100];
        n[1]=c;
        m[1]=1;
       // System.out.println(b+" "+c+" isneg="+isneg );
        if(b<c)
            return 0;
        if(b<c+c){
        	if(isneg==1)
        		return -1;
        	else
        		return 1;
        }
        int i;
        for(i=2;sum<Integer.MAX_VALUE/2;i++){
            sum+=sum;
            n[i]=sum;
            m[i]=m[i-1]+m[i-1];
            if(sum>b)
                break;
        }
        int res=0;
        for(int j=i-1;j>=1;j--){
            if(b>n[j]){
                b=b-n[j];
                res+=m[j];
            }
        }
        if(b==n[1])
        	res++;
        if(isneg==1)
            res=-res;
        return res;
    }
	public static void main(String[] args) {
		DeviceTwoInt dt=new DeviceTwoInt();
		int base=Integer.MIN_VALUE;
		System.out.println(base);
		int v=dt.divide(base, -1);
		System.out.println(v);
	}
}
