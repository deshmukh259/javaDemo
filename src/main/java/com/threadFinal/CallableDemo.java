package com.threadFinal;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {

        MyTask3 m = new MyTask3();

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> submit = service.submit(m);
        try {
            System.out.println("Result: " + submit.get());
            System.out.println("Hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }

    private static class MyTask3 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {

            Thread.sleep(5000);
            return 6 * 9;
        }
    }
}
