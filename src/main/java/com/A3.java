package com;

import java.util.ArrayList;
import java.util.List;

public class A3 {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ABC");
        list.add("234");
        list.add("@#$#@");
        list.add("ABCDEF");
        for (String string : list) {
            System.out.println(string);
            // list.add("zzz");
        }

        float c = 3.65f;
        float d = 3.65f;
        if (c == d) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        IT v = (e1, e2) -> {
            return e1 > e2;
        };

        System.out.println(v.bb(44, 45));

    }
}

@FunctionalInterface
interface IT {


    boolean bb(int v, int b);
}