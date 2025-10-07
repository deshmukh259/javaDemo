package com.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.java8.Java8Stream.println;
import static com.java8.Java8Stream.st;

public class Java8Empp {

    public static void main(String[] args) {
        st();
        println(0);


        Map<String, List<Empp>> collect = Empp.empList.stream()
                .filter(e -> e.add.equals("UK"))
                .collect(Collectors.groupingBy(e -> e.add));

        System.out.println(collect);
        collect.entrySet().stream().forEach(e -> println(e.getValue()));
        println(0);


    }
}
