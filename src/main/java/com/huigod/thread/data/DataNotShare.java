package com.huigod.thread.data;

/**
 * Created by teng on 2017/6/11.
 * 不共享数据的情况
 */
public class DataNotShare extends Thread {
    private int count = 5;

    public DataNotShare(String name) {
        super();
        //设置线程名称
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + this.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        DataNotShare a = new DataNotShare("A");
        DataNotShare b = new DataNotShare("B");
        DataNotShare c = new DataNotShare("C");
        a.start();
        b.start();
        c.start();
    }
}
