package cn.jsi.buaa;

public class Candy {
	int[] rs;
    int[] cnum;
    public boolean is1(int i){
        if(i==0){
            if(rs[1]>=rs[0])
                return true;
            else 
                return false;
        }
        if(i==rs.length-1){
            if(rs[rs.length-2]>=rs[rs.length-1])
                 return true;
            else
                return false;
        }
        if(rs[i-1]>=rs[i]&&rs[i+1]>=rs[i])
            return true;
        return false;
    }
    public void debug(){
    	for(int i: rs)
    		System.out.print(" "+i);
    	System.out.println();
    	for(int i: cnum)
    		System.out.print(" "+i);
    	System.out.println();
    	
    }
    public int candy(int[] ratings) {
        rs=ratings;
        if(rs.length==1)
            return 1;
        cnum=new int[rs.length];
        for(int i=0;i<rs.length;i++){
            if(is1(i)){
                cnum[i]=1;
                continue;
            }
            if(i>=1&&cnum[i-1]>0&&rs[i]>rs[i-1])
                cnum[i]=cnum[i-1]+1;
            else
                cnum[i]=-1;
        }
        for(int i=rs.length-1;i>=0;i--){
            if(i<rs.length-1&&cnum[i+1]>0&&rs[i]>rs[i+1]){
            	if(cnum[i]<=0||(cnum[i]>0&&cnum[i]<cnum[i+1]+1))
            		cnum[i]=cnum[i+1]+1;
            }
        }
        int sum=0;
         for(int i=0;i<rs.length;i++){
             sum+=cnum[i];
         }
         debug();
         return sum;
    }
    public static void main(String[] args) {
    	Candy c=new Candy();
    	Integer num=c.candy(new int[]{1,3,4,3,2,1});
    	
    	System.out.println("num="+num);
	}

}
