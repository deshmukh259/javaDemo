package com.lambda;

import java.util.stream.Stream;

public class ReduceDemo {

    public static void main(String[] args) {

        String na = Stream.of("P","u","r","u","s","h","o","t","t","a","m")
                .reduce("",(s,c)->s+c);
        System.out.println(na);

        int sum = Stream.of(1,2,3,4).reduce(0,(s,c)->s+c);
        System.out.println("sum = " + sum);


    }
}
