package com.threadFinal;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Producer extends Thread {

    Consumer consumer;

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        for (; ; ) {
            synchronized (consumer) {
                synchronized (this) {
                    WaitNotifyDemo.V++;
                    System.out.println("Producer : " + WaitNotifyDemo.V);
                    try {
                        sleep(100);
                        consumer.notify();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class Consumer extends Thread {

    Producer producer;

    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        for (; ; ) {
            synchronized (this) {
                synchronized (producer) {


                    System.out.println("Consumer : " + WaitNotifyDemo.V);
                    try {
                        //sleep(100);
                        producer.notify();
                        this.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}


public class WaitNotifyDemo {
    public static int V = 0;

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);
        producer.setConsumer(consumer);
        producer.start();
        consumer.start();
        System.out.println("Main done");
        HashSet n = new HashSet();
        n.add(consumer);
        ReadWriteLock v = new ReentrantReadWriteLock();
        Lock lock = v.writeLock();
        lock.lock();
        lock.unlock();
    }
}
