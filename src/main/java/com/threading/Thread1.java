package com.threading;

import java.util.ArrayList;
import java.util.List;

import static com.java8.Java8Stream.println;
import static com.java8.Java8Stream.st;

public class Thread1 {

    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    static  void stg1() {

        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(1);
        }
    }

    static synchronized void stg2() {

        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(1);
        }
    }

    public static void main(String[] args) {
        st();
        println("Start--");
        Runnable r1 = (() -> {
            process();
        });
        Runnable r2 = (() -> {
            process();
        });
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println(list1.size());
        println(list2.size());
    }

    private static void process() {
        for (int i = 0; i < 1000; i++) {
            stg1();
            stg2();
        }
    }
}


