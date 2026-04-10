package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface I1 {
    int f1(int i);
}
//
//class D1 implements I1 {
//
//    @Override
//    public void f1(int e) {
//        System.out.println("helloo " + e);
//        return e;
//    }
//}


public class demo1 {

    public static void main1(String[] args) {
        I1 i = e -> e + 100;
        int v = i.f1(448);
        System.out.println(v);

    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4);
        l.forEach(System.out::println);
        List<Integer> v= new ArrayList<>();

        System.out.println(l.stream().reduce(0,Integer::sum));

    }
}

