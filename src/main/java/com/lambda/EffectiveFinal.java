package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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


        Function<String,Boolean> isEmpty = (s)-> v.contains(s);
        System.out.println("isEmpty.apply(A) = " + isEmpty.apply("A"));

        BiFunction<String,String,String> bi3 =  String::concat;

        System.out.println(bi3.apply("Hello ","World"));

        Consumer<List<String>> con  = (li)-> li.sort(String::compareTo);

        List<String> a = Arrays.asList( "A", "Z", "xx", "s");
        System.out.println("a = " + a);
        con.accept(a);

        System.out.println("a = " + a);

    }
}
