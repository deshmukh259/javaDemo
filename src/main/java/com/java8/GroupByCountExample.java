package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByCountExample {
    public static void main(String[] args) {
        // Sample list of strings
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "apple", "kiwi", "banana", "kiwi", "kiwi");

        Map<String, Long> collect = strings.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(collect.size());
        collect.forEach((k,v)->{
            System.out.println(k+", "+v);
        });

        // Group by length and count occurrences in each group
        Map<Integer, Long> countByLength = strings.stream()
                .collect(Collectors.groupingBy(e->e.length(), Collectors.counting()));

        // Print the result
        countByLength.forEach((length, count) -> System.out.println("Length: " + length + " -> Count: " + count));
    }
}
