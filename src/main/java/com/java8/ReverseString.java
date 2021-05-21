package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReverseString {

    public static void main(String[] args) {
   String s = "abcd";
        Function<String , String> upp = String::toUpperCase;
        System.out.println(upp.apply(s));

        //Map<Object, List<char[]>> collect = Stream.of(s.toCharArray()).map(x -> x).collect(Collectors.groupingBy(x));
        //System.out.println(collect);

       // int v= () -> 4;
        String s3 = new String("aa");
        String s4= new String("aa");
        List<Object> l = new ArrayList<>();
        l.add(s3);
        l.add(s4);
        l.add(44l);
        System.out.println(l);
        class inn{
            final Integer s= 9;
            Integer c = 8;
            inn(){
                System.out.println(s+c);
            }

        }
    }
}
