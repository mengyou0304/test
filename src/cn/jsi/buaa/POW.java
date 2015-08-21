package cn.jsi.buaa;

public class POW {
	 boolean isneg=false;
	    int [] mask=new int[35];
	    double digui(double x,long n){
	        if(n==1)
	            return x;
	        double re= digui(x,n/2);
	        if(n%2==1)
	            re=re*x;
	        return re;
	    }
	    double force(double x,long n){
	        int tmp=1;
	        int i=0;
	        for(i=0;i<33;i++){
	            mask[i]=tmp;
	            tmp=tmp*2;
	            if(tmp>n)
	            	break;
	        }
	  //      System.out.println("n="+n+"i="+i);
	       i--;
	        double res=x;
	        while(true){
	            res=res*res;
	            if((mask[i]&n)>0){
	            //	System.out.println(mask[i]+"&"+n+"="+(mask[i]&n));
	                res*=x;
	            }
	            i--;
	       //     System.out.println("after count res="+res+" i="+i);
	            if(i==-1)
	                break;
	        }
	        return res;
	    }
	    
	    double getPOW(double x,long n){
	        double re=force(x,n);
	        if(isneg)
	            return 1/re;
	        else
	            return re;
	    }
	    public double pow(double x, int n) {
	        if(n==0)
	            return 1d;
	        if(x==0d)
	            return 0d;
	        if(n==1)
	        	return x;
	        if(n==-1)
	        	return 1/x;
	         long n2=n;
	        if(n2<0){
	            n2=n2*-1;
	            isneg=true;
	        }
	        return getPOW(x,n2);
	    }
    public static void main(String[] args) {
    	POW p=new POW();
    //	System.out.println(Integer.MAX_VALUE+""+Integer.MIN_VALUE+" 2147483648");
    	System.out.println(p.pow(1.00000, -2147483648));
	}
}
