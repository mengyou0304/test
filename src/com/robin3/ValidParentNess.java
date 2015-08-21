package com.robin3;

import java.util.Stack;

public class ValidParentNess {
	public boolean isValid(String s) {
        Stack<Integer> st=new Stack<Integer>();
        char[] cc=s.toCharArray();
        for(int i=0;i<cc.length;i++){
        		System.out.println(i);
            if(cc[i]=='(')
                st.push(1);
            if(cc[i]=='[')
                st.push(2);
            if(cc[i]=='{')
                st.push(3);
            if(cc[i]==')')
                if(st.size()==0||st.pop()!=1)
                    return false;
            if(cc[i]==']')
                if(st.size()==0||st.pop()!=2)
                    return false;
            if(cc[i]=='}')
                if(st.size()==0||st.pop()!=3)
                    return false;
        }
        if(st.size()>0)
            return false;
        return true;
    }
	public static void main(String[] args) {
		ValidParentNess vp=new ValidParentNess();
		System.out.println(vp.isValid("(){}[]"));
	}
}
