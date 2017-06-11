package com.huigod.thread.data;

/**
 * Created by teng on 2017/6/11.
 * 数据被多个线程共享
 */
public class DataShare extends Thread {
    private int count = 5;

    /**
     * 如果不加synchronized，将会出现“非线程安全”得到的结果将会异常
     */
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算,count=" + count);
    }

    public static void main(String[] args) {
        DataShare dataShare = new DataShare();
        Thread a = new Thread(dataShare, "A");
        Thread b = new Thread(dataShare, "B");
        Thread c = new Thread(dataShare, "C");
        Thread d = new Thread(dataShare, "D");
        Thread e = new Thread(dataShare, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
