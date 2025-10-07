package com.lambda;

import java.util.function.BiFunction;

public class ConstructorDemo {
    public static void main(String[] args) {

        BiFunction<Integer,Integer,Integer> bi3= (a,s)-> sum(a,s);
        System.out.println(bi3.apply(2,3));
    }

    public static int sum(Integer ... count){
        int sum = 0;
        for (Integer i : count) {
            sum+=i;
        }
        return sum;
    }
}
