package cn.jsi.buaa;

import java.util.ArrayList;

public class PascalTrangle2 {
	int[] res;
    ArrayList<Integer> list=new ArrayList<Integer>();
    public ArrayList<Integer> getRow(int n) {
    	n++;
        if(n==1){
            list.add(1);
            return list;
        }
        res=new int[n+5];
        for(int i=0;i<res.length;i++)
            res[i]=-1;
        res[0]=1;
        res[1]=1;
        for(int i=1;i<=n;i++){
            for(int j=i-2;j>=1;j--){
                res[j]=res[j-1]+res[j];
            }
            res[i-1]=1;
        }
        for(int i:res){
            if(i!=-1)
                list.add(i);
        }
        return list;
    }
    public static void main(String[] args) {
    	PascalTrangle2 t=new PascalTrangle2();
    	ArrayList<Integer> list=t.getRow(1);
    	for(int i:list)
    		System.out.print(i+" ");
		
	}

}
