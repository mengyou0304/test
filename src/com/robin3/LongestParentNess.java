package com.robin3;

import java.util.HashMap;

public class LongestParentNess {
    public int longestValidParentheses(String s) {
        char[] cc = s.toCharArray();
        int leftnum = 0;
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == '(') {
                leftnum++;
                if (map.get(leftnum) == null) {
                    map.put(leftnum, i);
                }
            } else {
                leftnum--;
                if (leftnum < 0)
                    map.clear();
                Integer v = map.get(leftnum + 1);
                if (v != null)
                    maxlen = Math.max(maxlen, i - v + 1);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestParentNess lp = new LongestParentNess();
        int v = lp.longestValidParentheses("())(()");
        System.out.println(v);
    }
}
