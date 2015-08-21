package cn.jsi.buaa;

import java.util.ArrayList;

public class RestoreIP {
	ArrayList<String> reslist=new ArrayList<String>();
    ArrayList<Integer> cuip=new ArrayList<Integer>();
    char[] cs;
    String s2;
    int len;
    public void genRes(){
        String s="";
        String s3="";
        for(int i=0;i<cuip.size();i++){
            s+=cuip.get(i)+".";
            s3+=cuip.get(i);
        }
      //  System.out.println("s2="+s2+" s3="+s3+"  s2==s  "+s2.equals(s3) );
        if(!s3.equals(s2))
            return;
        s=s.substring(0,s.length()-1);
     
        reslist.add(s);
    }
    public void dp(int p,int step){
//    	System.out.println("p="+p+" step="+step);
//    	System.out.println(cuip);
//        //to short
        if(len-p<step)
            return;
        //to long
        if(len-p>3*step)
            return;
        if(p==len&&step==0)
            genRes();
        if(p+1<=len){
            Integer i1=Integer.parseInt(s2.substring(p,p+1));
            cuip.add(i1);
            dp(p+1,step-1);
            cuip.remove(cuip.size()-1);
        }
        if(p+2<=len){
            Integer i2=Integer.parseInt(s2.substring(p,p+2));
            cuip.add(i2);
            dp(p+2,step-1);
            cuip.remove(cuip.size()-1);
        }
        if(p+3<=len){
            Integer i3=Integer.parseInt(s2.substring(p,p+3));
            if(i3<=255){
                cuip.add(i3);
                dp(p+3,step-1);
                cuip.remove(cuip.size()-1);
            }
        }
    }
    public ArrayList<String> restoreIpAddresses(String s) {
        cs=s.toCharArray();
        this.s2=s;
        len=cs.length;
        dp(0,4);
        return reslist;
    }
    public static void main(String[] args) {
		String s="010010";
		System.out.println("len="+s.length());
		RestoreIP rip=new RestoreIP();
		System.out.println(rip.restoreIpAddresses(s));
	}

}
