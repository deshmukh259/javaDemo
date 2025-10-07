package com.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaStream {


    public static void main(String[] args) {

 // emp-> sal -> asc

        List<String> list = Arrays.asList("abc","abc","xyz","xyz","pqr");

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println(collect);

        Map<String,String>  map= new HashMap();

        map.put("abcd","4");
        map.put("xyz","3");

        //map.compute()


    }
}
