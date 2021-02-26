package com.threadFinal;

class Writer1 extends Thread {

    Object book;
    Object pen;

    public Writer1(Object book, Object pen) {
        this.book = book;
        this.pen = pen;

    }

    public void run() {

        synchronized (book) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            synchronized (pen) {
                System.out.println(" Writer 1 wtiting");
            }
        }
    }
}

class Writer2 extends Thread {

    Object book;
    Object pen;

    public Writer2(Object book, Object pen) {
        this.book = book;
        this.pen = pen;

    }

    public void run() {

        synchronized (book) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            synchronized (pen) {
                System.out.println(" Writer 2 wtiting");
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        Object book = new Object(), pen = new Object();
        new Writer1(book, pen).start();
        new Writer2(book, pen).start();
        System.out.println("Main done");
    }
}
