package com;

import com.hackerrank.CountingValleys;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagarm2 {

    public static void main(String[] args) {

        String v1= "peek";
        String v2= "kepp";

        if(v1.length() != v2.length()) {
            System.out.println("not anagram string");
            return ;

        }
        Map<String, Long> collect = new HashMap<>();
        Map<String, Long> collect2 = new HashMap<>();
        for (char c : v1.toCharArray()) {

            Long l = collect.get(String.valueOf(c));
            if(l== null){
                String v = String.valueOf(c);
                collect.put(v,1L);
            }else {
                collect.put(String.valueOf(c),++l);
            }

        }
        for (char c : v2.toCharArray()) {

            Long l = collect2.get(String.valueOf(c));
            if(l== null){
                String v = String.valueOf(c);
                collect2.put(v,1L);
            }else {
                collect2.put(String.valueOf(c),++l);
            }

        }

        for (Map.Entry<String,Long> kv: collect.entrySet()){
            String key = kv.getKey();
            Long l = collect2.get(key);
            if(l != null){
               if( kv.getValue() == l ){
                   System.out.println(" anagram string");
                   return;
               }else {
                   System.out.println("not anagram string");
                   return;
               }
            }else {
                System.out.println("not anagram string");
                return;
            }

        }


    }
}
