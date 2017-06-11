package com.huigod.thread.data;

/**
 * Created by teng on 2017/6/11.
 */
public class Threadsafe {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ALogin extends Thread {
        @Override
        public void run() {
            Threadsafe.doPost("a", "aa");
        }
    }

    public static class BLogin extends Thread {
        @Override
        public void run() {
            Threadsafe.doPost("b", "bb");
        }
    }

    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }


}

