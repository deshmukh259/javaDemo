package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Stream {
    static long st1;

    public static void st() {
        st1 = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        st();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 5, 4, 4, 3, 3, 3, 3);
        Stream<Integer> integerStream = list.stream()
                .filter(e -> e > 6);
        println("--" + integerStream.
                reduce(0, Integer::sum));

        st();
        println(list.stream().
                mapToInt(e -> e + 10)
                .max().getAsInt());
        st();
        println(list.stream().sorted().collect(Collectors.toList()));

        st();
        println(list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));

        st();
        println(list.stream().max(Integer::compareTo));
        st();
        list.stream().forEach(System.out::println);
        println(0);

        st();
        Consumer<Integer> fun = e -> {
            System.out.println(e);
        };
        //list.stream().forEach(fun);

        println(0);
        println(0);
        st();
        Integer[] integers = list.stream().toArray(Integer[]::new);
        Stream.of(integers).forEach(System.out::println);
        println(0);
    }

    public static void println(Object o) {
        System.out.println("----------------------");
        System.out.println(o);
        System.out.println(System.currentTimeMillis() - st1 + "ms");
        System.out.println("----------------------");
    }

    interface A {
        static void println(Object o) {

            System.out.println(o);
            System.out.println(System.currentTimeMillis() - st1 + "ms");
        }
    }
}
