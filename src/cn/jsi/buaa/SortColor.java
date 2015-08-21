package cn.jsi.buaa;

public class SortColor {
	int[] a;
	public void clever(){
        int start=0;
        int end=a.length-1;
        for(int i=0;i<a.length;i++){
             if(i>end)
                break;
            if(a[i]==0)
                a[start++]=0;
            if(a[i]==2){
                a[i]=a[end];
                i--;
                a[end--]=2;
                if(i==end)
                    break;
            }   
        }
        while(end>=start)
            a[end--]=1;
    }
    public void sortColors(int[] A) {
        a=A;
        clever();
    }
    public static void main(String[] args) {
    	SortColor sc=new SortColor();
    	int[] ss=new int[]{0,1,2,0,1,2,2};
    	ss=new int[]{2,1};
    	sc.sortColors(ss);
    	for(int i:ss)
    		System.out.print(i+" ");
	}

}
