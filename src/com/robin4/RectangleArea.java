package com.robin4;

import java.util.Arrays;

/**
 * Created by robinmac on 15-8-25.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] x=new int[]{A,E,C,G};
        int[] y=new int[]{B,F,D,H};
        Arrays.sort(x);
        Arrays.sort(y);
//        DataGen.showArray(x);
//        DataGen.showArray(y);
        return (x[2]-x[1])*(y[2]-y[1]);
    }

    public static void main(String[] args) {
        RectangleArea r=new RectangleArea();
        int res=r.computeArea(-2, -2, 2, 2, -2, -2, 2, 2);
        System.out.println(res);

    }
}
