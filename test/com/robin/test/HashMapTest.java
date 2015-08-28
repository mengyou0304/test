package com.robin.test;

import java.util.HashSet;

/**
 * Created by robinmac on 15-8-26.
 */
public class HashMapTest {
    private void test1(){
        TmpOB o1=new TmpOB(1,"aaa");
        TmpOB o2=new TmpOB(1,"aaa");
        System.out.println(o1.hashCode());
        o2.a=3;
        System.out.println(o1.hashCode());
        Integer i=2;
        HashSet<TmpOB> set=new HashSet<TmpOB>();
        set.add(o1);
        set.add(o2);
        System.out.println(set.size());


    }
    public String getBit(Integer n){
        String s="";
        for(int i=0;i<32;i++) {
            s = "" + (n & 1) + s;
            n=n>>1;
        }
        return s;
    }
    public String getBit3(Integer n){
        String s="";
        for(int i=0;i<32;i++) {
            s = "" + (n & 1) + s;
            n=n>>>1;
        }
        return s;
    }
    public static void main(String[] args) {
        HashMapTest ht=new HashMapTest();
        ht.test1();
        int n=-1024;

        System.out.println(ht.getBit(n));
        System.out.println(ht.getBit(-n));
        System.out.println(ht.getBit(~(n-1)));
    }

}
class TmpOB{
    public TmpOB(Integer a,String b){
        this.a=a;
        this.b=b;

    }
    Integer a;
    String b;

}
