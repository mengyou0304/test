package com.robin4;

/**
 * Created by robinmac on 15-9-7.
 */
public class SleepSort {
    public void sort(int[] nums) {
        for (final int i : nums) {
            Thread d = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            });
            d.start();
        }
    }

    public static void main(String[] args) {
        SleepSort ss = new SleepSort();
        ss.sort(new int[]{1, 45, 6, 4, 23, 423, 4, 234, 23, 2, 211});
    }
}
