package com;

public class ThreadT {
    public static void main(String[] args) throws InterruptedException {

        Runnable r = () -> v(1000);
        new Thread(r).start();
        r = () -> v(2000);
        new Thread(r).start();
    }

    public static void v(int vv) {

        try {
            Thread.sleep(50);
            System.out.println(" in v " + vv + "   " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" out v " + vv + "   " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
