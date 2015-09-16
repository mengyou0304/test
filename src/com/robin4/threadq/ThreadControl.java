package com.robin4.threadq;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by robinmac on 15-9-15.
 */
public class ThreadControl {

    class PThread extends Thread{
         PThread son=null;
        final ReentrantLock lock=new ReentrantLock();
        final Condition condition=lock.newCondition();
         Integer sleepTime=1000;
        public PThread(Integer time,PThread sonThread){
            this.sleepTime=time;
            this.son=sonThread;
        }
        public void canStart(){
            lock.lock();
            try {
                condition.signal();
            }finally {
                lock.unlock();
            }

        }
        @Override
        public void run() {
            try {
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("[Start][" + sleepTime + "] Thread with sleep time " + sleepTime + " started");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[Finish][" + sleepTime + "] Thread with sleep time " + sleepTime + " Finish");
            super.run();
            if(son!=null)
                son.canStart();
        }
    }

    public void test() throws InterruptedException {
        PThread p3=new PThread(3000,null);
        PThread p2=new PThread(2000,p3);
        PThread p1=new PThread(1000,p2);
        p3.start();
        Thread.sleep(100);
        p2.start();
        Thread.sleep(100);
        p1.start();
        System.out.println("start finish");
        p1.canStart();
    }

    public static void main(String[] args) {
        ThreadControl tc=new ThreadControl();
        try {
            tc.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

    }
}
