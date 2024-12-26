package com.re;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Groupby1 {

    public static void main(String[] args) {
        List<String> li = Arrays.asList("one","two","three","four","five","six","seven","eight");

        Map<Integer, List<String>> collect = li.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("collect = " + collect);
        Map<Integer, Long> collect1 = li.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("collect1 = " + collect1);
        Map<Integer, List<String>> collect2 = li.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        Stream<Map.Entry<Integer, List<String>>> stream = collect2.entrySet().stream();
        Optional<Map.Entry<Integer, List<String>>> max = stream.max(Comparator.comparing(en -> en.getKey()));
        System.out.println("max = " + max);

        List<String> li1 = Arrays.asList("one","two","three","four","five","six","seven","eight","one","nine","nine","three","nnmnmnmnnm","three");
        //Supplier<List> sup =   ArrayList::new;
        List<String> collect3 = li1.stream().filter(e -> e.length() > 3).collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);
    
        //max length and number


        Optional<Map.Entry<Integer, List<String>>> max1 = li1.stream()
                .collect(
                        Collectors.groupingBy(e -> e.length(),Collectors.toList()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByKey());


        System.out.println("max1 = " + max1);

        //max number of duplicate

        Optional<Map.Entry<String, Long>> max2 = li1.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
                )
                .entrySet().stream().max(Map.Entry.comparingByValue());

        System.out.println("max2 = " + max2);

        //tomap

        Map<String, List<String>> collect4 = li1.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .collect(
                        Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue().stream().map(e1 -> e1.toUpperCase()).collect(Collectors.toList())
                        )
                );

        System.out.println("collect4 = " + collect4);

    }
}
