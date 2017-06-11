package com.huigod.thread.data;

/**
 * Created by teng on 2017/6/11.
 * println自带了synchronized但是i--执行在pringln前面，所以还是会出现线程安全问题,手动加上synchronized
 */
public class Threadsafe2 extends Thread{
    private int i =5;
    @Override
    synchronized public void run() {
        System.out.println("i=" + (i--) +" threadName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Threadsafe2 threadsafe2 = new Threadsafe2();
        Thread t1 = new Thread(threadsafe2);
        Thread t2 = new Thread(threadsafe2);
        Thread t3 = new Thread(threadsafe2);
        Thread t4 = new Thread(threadsafe2);
        Thread t5 = new Thread(threadsafe2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
