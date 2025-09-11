package com.java17;

import java.util.concurrent.locks.ReentrantLock;

public class ReenetrantLock {


    public static void main(String[] args) {

        CC c = new CC();
        Runnable r = () -> c.perform(44);
        Runnable t = () -> c.perform(90);
        new Thread(r).start();
        new Thread(t).start();
    }


}

class CC {
    ReentrantLock lock = new ReentrantLock();

    public void perform(int i) {
        try {
            System.out.println("Im trying "+Thread.currentThread());
            lock.lock();
            System.out.println("thremad  " + Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thremad " + Thread.currentThread() + " val " + i);
            perform2(i);
        } finally {
            lock.unlock();
        }
    }

    public void perform2(int i) {
        try {
            lock.lock();
            System.out.println("2 thremad " + Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(" 2 thremad" + Thread.currentThread() + " val " + i);

        } finally {
            lock.unlock();
        }
    }
}
