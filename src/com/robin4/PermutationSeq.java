package com.robin4;

import java.util.LinkedList;

/**
 * Created by robinmac on 15-9-7.
 */
public class PermutationSeq {

    public String getPermutation(int n, int k) {
        k--;
        LinkedList<Integer> tlist=new LinkedList<Integer>();
        int[] ts=new int[n+2];
        ts[1]=1;
        tlist.add(1);
        for(int i=2;i<=n;i++) {
            ts[i] = ts[i - 1] * i;
            tlist.add(i);
        }
        StringBuffer stb=new StringBuffer();
        for(int i=n-1;i>=1;i--) {
            int shang = k / ts[i];
            k=k-shang*ts[i];
            stb.append(tlist.remove(shang));
        }
        stb.append(tlist.get(0));
        return stb.toString();
    }

    public static void main(String[] args) {
        PermutationSeq ps=new PermutationSeq();
        System.out.println(ps.getPermutation(5,25));
    }
}
