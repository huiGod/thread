package com.huigod.thread.declare;

/**
 * Created by teng on 2017/6/11.
 * cpu执行哪个线程是有随机性.并且执行start方法的顺序不代表线程启动的顺序
 */
public class MyThreadExtend extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadExtend thread = new MyThreadExtend();
        thread.setName("myThread");
        thread.start();
        for (int i =0 ; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}

