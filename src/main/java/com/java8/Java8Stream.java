package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Stream {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,5,6,6,5,4,4,3,3,3,3);
        Stream<Integer> integerStream = list.stream().filter(e -> e > 2);
        System.out.println("");

    }
}
