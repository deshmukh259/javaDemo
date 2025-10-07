package com.threading;

public class multiThreading {
    static  int count = 1;

    public  static void inc() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = (() -> {
            for (int i = 0; i < 10000; i++, inc()) ;
        });
        Runnable r2 = (() -> {
            for (int i = 0; i < 10000; i++, inc()) ;
        });

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);

    }
}
