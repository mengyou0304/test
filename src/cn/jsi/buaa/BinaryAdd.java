package cn.jsi.buaa;

import java.util.ArrayList;

public class BinaryAdd {
	public String addBinary(String a, String b) {
        char[] c1=a.toCharArray();
        char[] c2=b.toCharArray();
        int p1=c1.length-1;
        int p2=c2.length-1;
        ArrayList<Integer> clist=new ArrayList<Integer>();
        while(p1>=0|p2>=0){
            int v1=0;
            int v2=0;
            if(p1>=0){
                v1=c1[p1]-'0';
                p1--;
            }
            if(p2>=0){
                v2=c2[p2]-'0';
                p2--;
            }
            int v=v1+v2;
            clist.add(v);
        }
        String s="";
        for(int i=0;i<clist.size();i++){
            int v=clist.get(i);
            if(v>1){
            	clist.set(i, v-2);
                Integer newv=0;
                if(i+1==clist.size()){
                	clist.add(1);
                }else{
                	 newv=clist.get(i+1);
                 	 clist.set(i+1,newv+1);
                }
            }
        }
        for(int i=clist.size()-1;i>=0;i--)
        	s+=clist.get(i);
        return s;
    }
	public static void main(String[] args) {
		char a='3';
		int v=a;
		BinaryAdd ba=new BinaryAdd();
		String res=ba.addBinary("11", "11");
		System.out.println(res);
		
	}

}
