package com.re;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SOrt82 {

    public static void main(String[] args) {
        List<Integer> vv = Arrays.asList(1,4,7,5,4,3,6,88,33,9,0);
        Stream<Integer> sorted = vv.stream().sorted(Comparator.reverseOrder()).skip(0);
        Stream<Integer> sorted1 = vv.stream().sorted(Comparator.reverseOrder()).skip(0);
        List<Integer> collect = sorted.collect(Collectors.toList());
        Map<Integer, Long> collect1 = sorted1.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect);
        System.out.println(collect1);

        Stream<String> sorted3 = vv.stream().map(e->e.toString()).sorted(Comparator.reverseOrder()).skip(0);
        String collect2 = sorted3.collect(Collectors.joining(", "));
        System.out.println("collect2 = " + collect2);

        IntSummaryStatistics intSummaryStatistics = vv.stream().filter(e -> e > 0).mapToInt(e -> e).summaryStatistics();
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);

        List<Double> collect3 = vv.stream().filter(e -> e > 0).map(e -> (double) e).collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

    }
}
