package com.robin4;

/**
 * Created by robinmac on 15-8-22.
 */
public class BasicCaculator2 {
    int res=0;
    int nres=0;
    int value=0;
    char nop='0';
    int op=1;

    boolean iscomputingN=false;
    //1+2+4*51
    public int calculate(String s) {

        char [] cc=s.toCharArray();
        for(int i=0;i<=cc.length;i++){
            if(i==cc.length){
                //TODO finish this
            }
            if(cc[i]>='0'&&cc[i]<='9')
                value=value*10+(cc[i]-'0');
            if(cc[i]=='+') {
                op = 1;
                finishNOP();
            }
            if(cc[i]=='-') {
                op = -1;
                finishNOP();
            }
            if(cc[i]=='*'||cc[i]=='/'){
                nop=cc[i];
                startNOP();
            }
            
            

        }
        return -1;

    }

    private void startNOP() {

    }

    private void finishNOP() {
        
    }

}
