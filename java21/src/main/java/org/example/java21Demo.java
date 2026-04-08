package org.example;

public class java21Demo {


    public static void main(String[] args) throws InterruptedException {


        Thread t = new Thread(new TD());
        System.out.println("start main");
        t.start();
        t.join();
        System.out.println("end main");

    }


}
class TD implements Runnable{

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("--display "+i);
        }
    }
}
