package com.robin4;

/**
 * Created by robinmac on 15-8-27.
 */
public class CompareVersions {
    public int s1(String ss1, String ss2) {
        String[] ss = ss1.split("[.]");
        String[] st = ss2.split("[.]");
        if (ss == null || ss.length == 0)
            ss = new String[]{ss1};
        if (st == null || st.length == 0)
            st = new String[]{ss2};
        int p = 0;
        int v1 = 0, v2 = 0;
        while (p < ss.length || p < st.length) {
            if (p >= ss.length || ss[p].length() == 0)
                v1 = 0;
            else
                v1 = Integer.parseInt(ss[p]);
            if (p >= st.length || st[p].length() == 0)
                v2 = 0;
            else
                v2 = Integer.parseInt(st[p]);
            p++;
            if (v1 != v2)
                return v1 - v2 > 0 ? 1 : -1;
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        return s1(version1, version2);
    }

    public static void main(String[] args) {
        CompareVersions cv = new CompareVersions();
        System.out.println(cv.compareVersion("0", "1"));
        System.out.println(cv.compareVersion("1", "0"));
        System.out.println(cv.compareVersion("0", "0"));
        System.out.println(cv.compareVersion("1", "1"));
        System.out.println(cv.compareVersion("1.0", "1.1"));


    }
}
