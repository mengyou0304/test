package com.robin4.threadq;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by robinmac on 15-9-15.
 */
public class BlockingQueueImpletation {
    int cap;
    final AtomicInteger count=new AtomicInteger(0);
    final ReentrantLock putlock=new ReentrantLock();
    final Condition notfull=putlock.newCondition();
    final ReentrantLock getlock=new ReentrantLock();
    final Condition notEmpty=getlock.newCondition();

    public BlockingQueueImpletation(int cap){
        this.cap=cap;
    }

    public void put(Integer v)throws InterruptedException{
        int c=-1;
        putlock.lockInterruptibly();
        try{
            while(count.get()==cap)
                notfull.await();
            realPutInQueue(v);
            c=count.getAndIncrement();
            if(c+1>cap)
                notfull.signal();

        }finally {
            putlock.unlock();
        }
        if(c==0) {
            getlock.lock();
            try {
                notEmpty.signal();
            }finally {
                getlock.unlock();
            }
        }


    }

    private void realPutInQueue(Integer v) {



    }

    public Integer take()throws InterruptedException{
        getlock.lockInterruptibly();
        Integer res =null;
        int c=-1;
        try{
            while(count.get()==0)
                notEmpty.await();
            res=realGetInQueue();
            c=count.getAndDecrement();
            if(c-1>0)
                notEmpty.signal();
        }finally{
            getlock.unlock();
        }
        putlock.lock();
        try {
            notfull.signal();
        }finally {
            putlock.unlock();
        }
        return res;
    }

    private Integer realGetInQueue() {
        return -1;

    }
}
