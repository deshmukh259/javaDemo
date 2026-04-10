package com.threading;

import java.time.LocalDateTime;

public class InteruptDemo {

    public static void main(String[] args) {
        Runnable r = (() -> {
            try {
                System.out.println("T start");
                Thread.sleep(10000);
                LocalDateTime localDateTime = LocalDateTime.now();
                while (true) {

                }
            } catch (InterruptedException e) {
                System.out.println("I got call I hav to go");
                e.printStackTrace();
            }
            System.out.println("Ret");
            return;
        });

        Runnable r1 = (() -> {
            try {
                System.out.println("T1 start");
                Thread.sleep(10000);
                LocalDateTime localDateTime = LocalDateTime.now();
                while (true) {

                }
            } catch (InterruptedException e) {
                System.out.println("1 I got call I hav to go");
                e.printStackTrace();
            }
            System.out.println("Ret");
            return;
        });
        new Thread(r1).start();
        Thread t = new Thread(r);
        t.start();
        try {
            Thread.sleep(8000);
            System.out.println("Call Interrupt");
            t.interrupt();
            System.out.println("done");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
