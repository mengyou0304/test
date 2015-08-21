package cn.jsi.buaa;

public class BestTimeStock3 {
	int[] we;
	public int maxProfit(int[] p) {
	    we=new int[p.length];
	    int min=Integer.MAX_VALUE;
	    int currentp=0;
	    int maxp=0;
	    for(int i=0;i<p.length;i++){
	    	if(min>p[i])
	    		min=p[i];
	    	currentp=p[i]-min;
	    	if(maxp<currentp)
	    		maxp=currentp;
	    	we[i]=maxp;
	 //   	System.out.print(we[i]+"("+i+") ");
	    }
	 //   System.out.println();
	    int max=0;
	    currentp=0;
	    maxp=0;
	    int allmax=0;
	    for(int i=p.length-1;i>=0;i--){
	    	if(max<p[i])
	    		max=p[i];
	    	currentp=max-p[i];
	    	if(maxp<currentp)
	    		maxp=currentp;
	    	int tmp=we[i]+maxp;
	    	if(allmax<tmp)
	    		allmax=tmp;
	    }
	//    System.out.println();
	    return allmax;
	}
	public static void main(String[] args) {
		BestTimeStock3 p=new BestTimeStock3();
		int v=p.maxProfit(new int[]{2,1,2,0,1});
		System.out.println(v	);
	}

}
