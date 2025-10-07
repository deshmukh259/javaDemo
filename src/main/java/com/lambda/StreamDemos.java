package com.lambda;

import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class StreamDemos {

    public static void main(String[] args) {
        Stream<String> strSt = Stream.of("Abcd", "xyz", "a9", "gh", "a30", "a40");
        Stream<String> str2St = Stream.of("A1", "A2", "A3", "A4", "A5");
        Stream<Integer> intSt = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<String> contca = Stream.concat(strSt, str2St);
        //contca.distinct().forEach(System.out::println);
        //    System.out.println(contca.distinct().forEach(System.out::println));
        // System.out.println(contca.count());
        Consumer<String> consumer = System.out::println;
        IntPredicate b= (nn)-> nn>44;
        System.out.println(b.getClass().getSimpleName());
        System.out.println(consumer.getClass().getSimpleName());
        System.out.println(contca.distinct().peek(consumer).count());
    }
}
