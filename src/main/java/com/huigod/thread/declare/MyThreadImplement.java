package com.huigod.thread.declare;

/**
 * Created by teng on 2017/6/11.
 * 随机性
 */
public class MyThreadImplement implements Runnable{
    @Override
    public void run() {
        System.out.println("进行中!");
    }

    public static void main(String[] args) {
        Runnable runnable = new MyThreadImplement();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束!");
    }
}
