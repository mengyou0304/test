package com.robin4;

/**
 * Created by robinmac on 15-8-31.
 */
public class LongestPalindromString {

    public String longestPalindrome(String s) {
        int maxlen = 0;
        int maxstart=-1;
        int maxend=-1;
        char[] cc = s.toCharArray();
        // i-delta i i+delta
        for (int i = 0; i < cc.length; i++)
            for (int delta = 0; delta < cc.length; delta++)
                if (i - delta >= 0 && i + delta < cc.length)
                    if (cc[i - delta] == cc[i + delta]) {
                        if(maxlen<1+delta*2){
                            maxstart=i-delta;
                            maxend=i+delta;
                            maxlen=1+delta*2;
                        }
                    }
                    else
                        break;
        // i-delta,i,i+1,i+1+delta
        for (int i = 0; i < cc.length; i++)
            for (int delta = 0; delta < cc.length; delta++)
                if (i - delta >= 0 && i + 1 + delta < cc.length)
                    if (cc[i - delta] == cc[i + 1 + delta]) {
                        if(maxlen<2+delta*2){
                            maxstart=i-delta;
                            maxend=i+delta+1;
                            maxlen=2+delta*2;
                        }
                    }
                    else
                        break;
        StringBuffer sb=new StringBuffer();
        for(int i=maxstart;i<=maxend;i++)
            sb.append(cc[i]);
        return sb.toString();
    }

}
