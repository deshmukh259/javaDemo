package com.threadFinal;

import static com.threadFinal.ThreadWait.sleep;

public class ThreadWait {
    public static void main(String[] args) {

        MyTask1 task = new MyTask1();

        Thread t = new Thread(task);
        t.start();

        sleep(2000);
        try {
            for (int i = 0; i < 1500; i++) {
                System.out.print(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sleep(2000);
        t.notify();
        t.interrupt();

        System.out.println("Main thred done");


    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyTask1 implements Runnable {
    @Override
    public void run() {

        System.out.println("t started");

        for (; ; ) {
            if (Thread.interrupted()) {
                System.out.println("Im stopping here");
                break;
            }
            sleep(50);
            System.out.print("-");
        }
    }
}

