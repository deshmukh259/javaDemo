package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello, World!");

        System.out.println("Abccc %s".formatted("44"));

        for (int i = 0; i < 2; i++) {

            Thread.startVirtualThread(()-> {
                try {
                    process(System.currentTimeMillis());
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).join();
        }


    }

    private static void process(long l) throws ExecutionException {

        System.out.println(Thread.currentThread()+"-------------"+l);
        List<String> li = List.of("A","B","C","D");

       try( ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()){

           List<Callable<String>> taskList = new ArrayList<>();
           for (String s : li) {
               taskList.add(()->tasker(s));


           }

           System.out.println("---SUBMIT--");

           List<Future<String>> futures = es.invokeAll(taskList);

           for (Future<String> future : futures) {
               System.out.println(future.get());
           }
           System.out.println(Thread.currentThread()+"-------------"+l);

       } catch (InterruptedException e) {


       }


    }

    private static String tasker(String s) throws InterruptedException {
        Thread.sleep(100);
        return Thread.currentThread()+"***************"+s ;
    }

    private static Object vo() {
        return null;
    }
}