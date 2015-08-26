package com.robin4;

import java.util.Stack;

/**
 * Created by robinmac on 15-8-21.
 */
public class BasicCalculator {
    public int calculate(String s) {
        return calculateShort(s);
    }

    public int calculateShort(String s) {
        char[] cc=s.toCharArray();
        Stack<Integer> st=new Stack<Integer>();
        //inallop only change when go in/out ( )
        Integer inallop=1;
        Integer cop=1;
        Integer res=0;
        Integer value=0;
        for(int i=0;i<=cc.length;i++){
            if(i==cc.length){
                res+=cop*inallop*value;
                break;
            }
            if(cc[i]>='0'&&cc[i]<='9'){
                value=value*10+(cc[i]-'0');
            }else {
                res+=cop*inallop*value;
                value = 0;
            }
            //operator
            if(cc[i]=='+')
                cop=1;
            if(cc[i]=='-')
                cop=-1;
            //()
            //-(1+3+(2+4-(3+5))+5)
            if(cc[i]=='('){
                st.push(cop);
                inallop=inallop*cop;
                cop=1;
            }
            if(cc[i]==')')
                inallop=inallop*st.pop();
//            System.out.println("cc[i]="+cc[i]+" cop="+cop+" inallop="+inallop+" value="+value+" res="+res);
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator bc=new BasicCalculator();
        System.out.println("res="+bc.calculate("(100+22)-(6+8)"));
        System.out.println("res="+bc.calculate("11+2"));
        System.out.println("res="+bc.calculate("11+12"));
        System.out.println("res="+bc.calculate("111"));



    }

}
