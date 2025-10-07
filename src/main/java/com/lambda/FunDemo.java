package com.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunDemo {


    public static void main(String[] args) {
        Function<Integer,Integer> v = s-> s*2;

        System.out.println("v.apply(2)*2 = " + v.apply(2));

        BiFunction<Integer,Integer,String> bi = (s1,s2)-> "multiply ="+(s1*s2);

        System.out.println("bi.apply(2,3) = " + bi.apply(2,3));
   
    }

    
}

