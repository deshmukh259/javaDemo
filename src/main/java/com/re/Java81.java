package com.re;

import java.util.Map;
import java.util.stream.Collectors;

public class Java81 {


    public static void main(String[] args) {

        String a = "fsdfsdfndsnfdsnfsdfsfsfmsdmfdf";
        Map<Character, Long> collect = a.chars().mapToObj(c -> (char) c)
                //.map(e -> String.valueOf(e))
                .collect(Collectors.groupingBy(e1 -> e1, Collectors.counting()));
        System.out.println(collect);


    }
}
