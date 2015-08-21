package cn.jsi.buaa;

import java.util.ArrayList;

public class PalindromePartitioning {
	ArrayList<ArrayList<String>> reslist=new ArrayList<ArrayList<String>>();
    int len;
    char[] ins;
    String os;
    
    public void genRes(ArrayList<String> res){
        ArrayList<String> tres=new ArrayList<String>();
        for(String s:res)
            tres.add(s);
        reslist.add(tres);
    }
    public boolean isPa(int start,int end){
        boolean isp=true;
        while(start<=end){
            if(ins[start]!=ins[end]){
                isp=false;
                break;
            }
            start++;
            end--;
        }
        return isp;
    }
    public void dp(int number,ArrayList<String> res){
        if(number==len)
            genRes(res);
        for(int i=number;i<len;i++){
            if(isPa(number,i)){
                res.add(os.substring(number,i+1));
                dp(i+1,res);
                res.remove(res.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        if(s==null||s.length()==0)
            return reslist;
        len=s.length();
        ins=s.toCharArray();
        os=s;
        ArrayList<String> tres=new ArrayList<String>();
        dp(0,tres);
        return reslist;
        
    }
    public static void main(String[] args) {
    	PalindromePartitioning p=new PalindromePartitioning();
    	System.out.println(p.partition("aabbc"));
	}

}
