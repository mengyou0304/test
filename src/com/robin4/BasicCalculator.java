package com.robin4;

import java.util.Stack;

/**
 * Created by robinmac on 15-8-21.
 */
public class BasicCalculator {
    String s="(1+(4+5+2)-3)+(6+8)";
//    Stack<Integer> opst=new Stack<Integer>();
    Stack<Integer> numst=new Stack<Integer>();
    Integer value=0;

    public int calculate(String s) {
        char[] cc=s.toCharArray();
        boolean isNegtive=false;
        for(int i=0;i<cc.length;i++){
            char c=cc[i];
            if(c==' ') {
                finishValue();
                continue;
            }
            if(c=='-') {
                finishValue();
                isNegtive = true;
            }
            if(c=='+') {
                finishValue();
                isNegtive = false;
            }
            if(c=='('||c==')'){
                finishValue();


            }
            if (c>='0'&&c<='9') {
                value=value*10+(c-'0');
            }
        }
        return -1;
    }

    private Integer finishValue(){
        numst.push(value);
        value=0;

    }
}
