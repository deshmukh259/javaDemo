package com.java8;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByCountExample {
    public static void main(String[] args) {
        // Sample list of strings
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "apple", "kiwi", "banana", "kiwi", "kiwi");

        // Group by length and count occurrences in each group
        Map<Integer, Long> countByLength = strings.stream()
                .collect(Collectors.groupingBy(e->e.length(), Collectors.counting()));

        // Print the result
        countByLength.forEach((length, count) -> System.out.println("Length: " + length + " -> Count: " + count));
    }
}
