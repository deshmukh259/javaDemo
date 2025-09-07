package com.lambda;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class EffectiveFinal {

    public static void main(String[] args) {
        int x =344;

        Predicate<String> p = (s)-> s.length()>0;
        System.out.println(p.test("Abcd"));
        System.out.println(p.test(""));

        String v = "Abc";

        Supplier<String> k = v::toLowerCase;
        System.out.println("k.get() = " + k.get());

        Supplier<String> up = () -> v.toUpperCase();
        System.out.println("up.get() = " + up.get());
    }
}
