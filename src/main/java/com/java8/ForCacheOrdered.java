package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForCacheOrdered {

    public static void main(String[] args) {

        m();
    }

    private static void m() {
        long x = System.currentTimeMillis();
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        List<Integer> listOfIntegers =
                new ArrayList<>(Arrays.asList(intArray));
        listOfIntegers
                .stream().sorted()
                .forEach(e -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.print(e + " ");
                });
        System.out.println("");
        System.out.println(System.currentTimeMillis()-x);
    }
}
/*
* .stream().parallel()
                .forEachOrdered(e -> {
                    try {
* */