package org.example;

import java.util.ArrayList;
import java.util.List;

public class CPDemo {

    public static int v = 0;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args) {

        Consumer c = new Consumer(li);
        Produce p = new Produce(li);
        Thread t1 = new Thread(() -> c.consume());
        Thread t2 = new Thread(() -> p.produce());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end of main");
    }
}

class Produce {

    private List<Integer> li;

    public Produce(List<Integer> li) {
        this.li = li;
    }

    public void produce()  {
        while (true) {
            synchronized (li) {
            while (!li.isEmpty()) {
                    try {
                        System.out.println("waiting to consume");
                        li.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }  {
                synchronized (li) {
                    CPDemo.v += 1;
                    System.out.println("produced " + CPDemo.v);
                    li.add(CPDemo.v);
                    li.notifyAll();
                }
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("---------PRODUCE--------");
        }
    }
}


class Consumer {

    private List<Integer> li;

    public Consumer(List<Integer> li) {
        this.li = li;
    }

    public void consume() {
        while (true) {
            synchronized (li) {
            while (li.isEmpty()) {
                    try {
                        System.out.println("waiting to produce....");
                        li.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                    }
                }
            }  {
                synchronized (li) {
                    System.out.println("Consumed : " + li);
                    li.clear();
                    li.notifyAll();
                }
            }
            System.out.println("-----------CONSUME----------");
        }

    }
}
