package com.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryOpDemo {

    public static void main(String[] args) {

        UnaryOperator<Integer> inc = s-> ++s;

        System.out.println(inc.apply(4));

        BinaryOperator<String> c = (s1,s2)-> s1.concat(s2);

        System.out.println("c.apply(\"Andy\",\"Will\") = " + c.apply("Andy","Will"));
    }
}
