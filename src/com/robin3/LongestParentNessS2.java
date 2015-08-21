package com.robin3;

import java.util.Stack;

public class LongestParentNessS2 {
    public int longestValidParentheses(String s) {
        char[] cc = s.toCharArray();
        int maxlen = 0;
        int clen = 0;
        int cv = 0;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == '(')
                cv++;
            else
                cv--;
            if (cv >= 0) {
                clen++;
                if (cv == 0)
                    maxlen = Math.max(maxlen, clen);
            } else {
                cv = 0;
                clen = 0;
            }
        }
        System.out.println("l->R: " + maxlen);
        int max2 = maxlen;
        maxlen = 0;
        clen = 0;
        cv = 0;
        for (int i = cc.length - 1; i >= 0; i--) {
            if (cc[i] == ')')
                cv++;
            else
                cv--;
            if (cv >= 0) {
                clen++;
                if (cv == 0)
                    maxlen = Math.max(maxlen, clen);
            } else {
                cv = 0;
                clen = 0;
            }
        }
        System.out.println("L<-R: " + maxlen);
        return Math.max(max2, maxlen);
    }

    public int longestValidParentheses2(String s) {
        char[] cc = s.toCharArray();
        Stack<Integer> st = new Stack<Integer>();
        int maxlen = 0;
        int start = cc.length;
        int lastmatch = 0;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == '(')
                st.push(i);
            else {
                if (st.size() > 0) {
                    lastmatch = st.pop();
                    start = Math.min(start, lastmatch);
                    if (st.size() == 0)
                        maxlen = Math.max(maxlen, i - start + 1);

                } else
                    start = cc.length;
            }
        }
        if (st.size() > 0)
            maxlen = Math.max(maxlen, cc.length - lastmatch);
        return maxlen;
    }

    public static void main(String[] args) {
        LongestParentNessS2 lp = new LongestParentNessS2();
        int v = 0;
        v = lp.longestValidParentheses2("())(()");
        System.out.println(v);
        v = lp.longestValidParentheses2("()(()");
        System.out.println(v);
        v = lp.longestValidParentheses2("(()");
        System.out.println(v);


    }
}
