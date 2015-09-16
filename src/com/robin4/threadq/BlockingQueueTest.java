package com.robin4.threadq;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by robinmac on 15-9-15.
 */
public class BlockingQueueTest {
    class Node{
        Node next;
        Integer value;
        Node(Integer v){
            this.value=v;
        }
    }
    Node dhead=new Node(-1);

    final Integer capacity=2;

    final AtomicInteger count=new AtomicInteger(0);

    final ReentrantLock putlock=new ReentrantLock();
    final Condition notfull=putlock.newCondition();

    final ReentrantLock takelock=new ReentrantLock();
    final Condition notempty=takelock.newCondition();

    public void put(Integer v) throws InterruptedException{
        putlock.lockInterruptibly();
        int c=-1;
        try {
            while (count.get() == capacity)
                notfull.await();
            Node tnode = new Node(v);
            tnode.next = dhead.next;
            dhead.next = tnode;
            c=count.getAndIncrement();
            if(c+1<capacity)
                notfull.signal();
        }finally {
            putlock.unlock();
        }
        if(c==0)
            notempty.signal();
    }

    public Integer take() throws InterruptedException{
        takelock.lockInterruptibly();
        int c=-1;
        Node d=null;
        try{
            while(count.get()==0)
                notempty.wait();
            d=deQueue();
            c=count.getAndDecrement();
            if(c>1)
                notempty.signal();
        }finally {
            takelock.unlock();
        }
        if(c==capacity) {
            putlock.lock();
            try {
                notfull.signal();
            }finally{
                putlock.unlock();
            }
        }
        return d.value;

    }

    private Node deQueue() {
        return null;
    }


}
