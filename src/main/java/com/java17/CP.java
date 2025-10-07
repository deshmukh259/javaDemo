package com.java17;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class CP {


    public static void main(String[] args) {
        A a = new A();
        Runnable z = () -> a.producer();
        Runnable c = () -> a.consumer();

        new Thread(z).start();
        new Thread(c).start();


    }


}

class A {

    List<Integer> a = new ArrayList<>();

    public void producer() {

        while (true) {
            //System.out.println("thread = " + Thread.currentThread());

            synchronized (this) {
                if (a.isEmpty()) {
                    System.out.println("thread inside= " + Thread.currentThread());
                    a.add(RandomGenerator.getDefault().nextInt());
                    System.out.println("Generated new ele: " + a);
                    try {
                        //Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("-------wait done----");
                    this.notifyAll();

                }else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }

    }

    public void consumer() {

        while (true) {

            synchronized (this) {
                if (!a.isEmpty()) {
                    int v = a.remove(0);
                    System.out.println("Consumed: " + v + " List: " + a);
                    try {
                       // Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("-------WAIT DONE----");
                    this.notifyAll();

                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }

    }

}
