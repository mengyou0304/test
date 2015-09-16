package com.robin.test;

import com.robin3.utility.DataGen2;

public class TestM1 {
    public static void main(String[] args) {
        int i = 129;
        DataGen2.showBit(~i);
        DataGen2.showBit(i);
        DataGen2.showBit(-i);
        DataGen2.showBit(i & (-i));
        System.out.println();


    }


}
