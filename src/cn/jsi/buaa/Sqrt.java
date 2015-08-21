package cn.jsi.buaa;

public class Sqrt {
	 public int sqrt(int x) {
	        if(x<1)
	            return 0;
	        int n2=0;
	        int max=n2;
	        for(int i=1;i<46342;i++){
	            max+=2*i-1;
	            System.out.println("i="+i+" max="+max);
	            if(max>x)
	                return i-1;
	            if(max==x)
	            	return i;
	        }
	        return 0;
	        
	    }
	 public static void main(String[] args) {
		 Sqrt s=new Sqrt();
		 int i=s.sqrt(2147483647);
		 Double g=Math.sqrt(2147483647d);
		 System.out.println(i+" "+g.intValue());
	}
}
