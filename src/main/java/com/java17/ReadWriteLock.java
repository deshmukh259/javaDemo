package com.java17;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.random.RandomGenerator;

public class ReadWriteLock {


    public static void main(String[] args) {

        Mainn m = new Mainn();

      new Thread(() -> m.readOnly()).start();
      new Thread(() -> m.write()).start();
      new Thread(() -> m.readOnly()).start();
      new Thread(() -> m.write()).start();

    }


}

class Mainn {

    private List<Integer> li = new ArrayList<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public void readOnly() {

        try {
            readLock.lock();
            System.out.println("reading li : " + li);

        } finally {
            readLock.unlock();
        }
    }

    public void write() {

        try {
            writeLock.lock();
            System.out.println("wrriting li : " + li);
            li.add(RandomGenerator.getDefault().nextInt());
            System.out.println("wrrited li : " + li);

        } finally {
            writeLock.unlock();
        }
    }


}
