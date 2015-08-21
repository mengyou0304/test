package cn.jsi.buaa;

public class JumpGame {
	int[] step;
    int[] reached;
    int[] points;
    int len;
    boolean finded=false;
    int dp(int index){
    	System.out.println("tring..."+index);
    	if(index+step[index]>=len-1)
    		return 0;
    	int tmp=0;
    	int min=9999999;
    	for(int i=index+1;i<=index+step[index];i++){
    		tmp=dp(i);
    		if(reached[index]<tmp+1)
    			reached[index]=tmp+1;
    	}
    	System.out.println("return  "+reached[index]);
    	return reached[index];
    	
    }
    public void debugd(){
    	for(int i=0;i<len;i++){
    		System.out.print( step[i]+" ");
    	}
    	System.out.println();
    	for(int i=0;i<len;i++){
    		System.out.print( reached[i]+" ");
    	}
    	System.out.println();
    
    }
    public int brootForce2(){
    	points[0]=0;
    	points[1]=step[0];
    	int max=0;
    	int farstep=0;
    	while(true){
    	//	System.out.println("farstep="+farstep+"  max="+max);
    		if(points[max+1]>len-1)
    			return max+1;
    		for(int i=points[max+1];i>points[max];i--){
    			System.out.println("i="+i);
    		//	debugd();
    			if(reached[i]>max+1)
    				reached[i]=max+1;
    			if(farstep<i+step[i])
    				farstep=i+step[i];
    			if(i>=len-1)
    				return max+1;
    			System.out.println("farstep="+farstep);
    			if(farstep>=len-1)
    				return max+2;
    		}
    		max++;
    		points[max+1]=farstep;
    	}
    	
    }
    public boolean  brootForce(){
    	int maxs=0;
    	for(int i=0;i<step.length;i++){
    		System.out.println("i="+i+" maxs="+maxs);
    		if(i>maxs)
    			return false;
    		if(step[i]+i>maxs)
    			maxs=step[i]+i;
    		if(maxs>=step.length-1)
    			return true;
    	}
        return false;
    }
    public int canJump(int[] A) {
    	step=A;
    	len=A.length;
        reached=new int[A.length+5];
        points=new int[A.length+5];
        for(int i=0;i<A.length;i++){
            reached[i]=99999;
            points[i]=0;
        }
       if(A.length<=1)
    	   return 0;
       
       return brootForce2();
      //  return brootForce();
    }
    public int[] testData(){
    	//int[] A=new int[]{6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};
     	int[] A=new int[]{3,2,3};
        
    	return A;
    			
    	
    }
    public static void main(String[] args) {
    	JumpGame j=new JumpGame();
    	int[] values=j.testData();
    	System.out.println("length:"+values.length);
    	int re=j.canJump(values);
    	System.out.println(re);
	}
}
