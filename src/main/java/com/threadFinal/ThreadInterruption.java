package com.threadFinal;

public class ThreadInterruption {
    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread t = new Thread(task);
        t.start();

        try {
            System.out.println("sleep");
            Thread.sleep(5000);
            System.out.println("sleep after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        t.interrupt();

        System.out.println("Main thred done");


    }
}


class MyTask implements Runnable {
    @Override
    public void run() {

        System.out.println("t started");

        for (; ; ) {
            if (Thread.interrupted()) {
                System.out.println("Im stopping here");
                break;
            }
            System.out.print("-");
        }
    }
}

