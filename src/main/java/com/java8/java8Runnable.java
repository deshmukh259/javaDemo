package com.java8;

public class java8Runnable {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        System.out.println("end");


    }
}
