package com.robin4;

/**
 * Created by robinmac on 15-8-21.
 */
public class LongestParentness {
    char[] cc;
    int[] le;
    boolean[] valide;
    int maxlen=0;
    public int longestValidParentheses(String s) {
        cc=s.toCharArray();
        int len=cc.length;
        le=new int[len+1];
        valide=new boolean[len+1];
        for(int i=0;i<len+1;i++)
            valide[i]=true;
        for(int i=0;i<len;i++){
            int num=cc[i]=='('?1:-1;
            for(int j=0;j<=i;j++){
                le[j]+=num;
                if(le[j]<0)
                    valide[j]=false;
                if(valide[j]&&le[j]==0)
                    maxlen=Math.max(maxlen,i-j);
            }
        }
        return maxlen;
    }
    public int longestValidParentheses2(String s) {
        if(s==null||s.length()==0)
            return 0;
        cc=s.toCharArray();
        int cnum=0;
        int st=0;
        int maxv=0;
        //from left to right
        for(int i=0;i<cc.length;i++){
            int v=cc[i]=='('?1:-1;
            cnum+=v;
            if(cnum<0){
                st=i+1;
                cnum=0;
            }
            if(cnum==0){
                int clen=i-st+1;
                maxv=Math.max(maxv,clen);
            }
        }
        cnum=0;
        st=cc.length-1;
        for(int i=cc.length-1;i>=0;i--){
            int v=cc[i]==')'?1:-1;
//            System.out.println("i="+i+"  v="+v);
            cnum+=v;
            if(cnum<0){
                st=i-1;
                cnum=0;
            }
            if(cnum==0) {
                int clen=st - i + 1;
//                System.out.println("clen="+clen);
                maxv = Math.max(maxv, st - i + 1);
            }

        }
        return maxv;
    }

    public static void main(String[] args) {
        LongestParentness lp=new LongestParentness();
        int v=lp.longestValidParentheses2("()(()");
        System.out.println(v);
    }

}
