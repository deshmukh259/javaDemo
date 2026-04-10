package com.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekDemo {

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1,3,5,7,33,44,11,55);

        List v = li.stream().peek(System.out::println)
                .filter(e->e>4)
                .peek(System.out::println)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("v = " + v);

         Stream.iterate(2,n->n+2).peek(e->System.out.println("peek-> "+e)).limit(20)
                .forEach(System.out::println);
    }
}
