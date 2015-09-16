package com.robin4.threadq;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by robinmac on 15-9-15.
 */
public class SimpleThread {
    final ReentrantLock lock=new ReentrantLock();
    final Condition condition=lock.newCondition();

    public void canStart(){
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }

    }

    public void canStop() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }

    }
    public void test() throws InterruptedException {

    }

    public static void main(String[] args) {
        SimpleThread tc=new SimpleThread();
            tc.canStart();
    }
}
