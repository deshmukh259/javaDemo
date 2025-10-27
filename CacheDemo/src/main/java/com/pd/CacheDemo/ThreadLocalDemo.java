package com.pd.CacheDemo;

public class ThreadLocalDemo {


    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {

        Runnable r = () -> {

            String name = Thread.currentThread().getName();
            System.out.println("Thread.currentThread().getName() = " + name);

            LOCAL.set(name);
            System.out.println(name + "LOCAL = " + LOCAL.get());


        };



        new Thread(r,"Thread-1").start();
        new Thread(r,"Thread-2").start();


    }


}
