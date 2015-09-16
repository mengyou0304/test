package com.robin4;

import cn.jsi.buaa.basic.DataGen;

/**
 * Created by robinmac on 15-9-8.
 */
public class AddOne {
    public int[] plusOne(int[] di) {
        int[] nres=new int[di.length+1];
        nres[0]=1;
        boolean added=false;
        for(int i=di.length-1;i>=0;i--){
            if(di[i]!=9){
                di[i]++;
                added=true;
            }else{
                di[i]=0;
            }
        }
        if(!added)
            return nres;
        else
            return di;
    }

    public static void main(String[] args) {
        AddOne ao=new AddOne();
        DataGen.showArray(ao.plusOne(new int[]{8,9,9,9,9,9,9}));
    }
}
