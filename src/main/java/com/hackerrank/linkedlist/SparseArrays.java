package com.hackerrank.linkedlist;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SparseArrays {


    public static void main(String[] args) {
        String[] s = new String[]{"ab", "ab", "abc"};
        String[] q = new String[]{"ab", "abc", "bc"};
        s = new String[]{"aba", "baba", "aba", "xzxb"};
        q = new String[]{"aba", "xzxb", "ab"};
        int[] ints = matchingStrings(s, q);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    static int[] matchingStrings(String[] strings, String[] queries) {

        if (strings.length < 1 || strings.length > 10000 || queries.length < 1 || queries.length > 1000) {
            return null;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    int v = res[i];
                    v += 1;
                    res[i] = v;
                }
            }
        }

        return res;
    }

    // Complete the matchingStrings function below.
    static int[] matchingStrings1(String[] strings, String[] queries) {

        if (strings.length < 1 || strings.length > 10000 || queries.length < 1 || queries.length > 1000) {
            return null;
        }

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String qu : queries) {
            if (qu.length() < 1 || qu.length() > 20)
                return null;
            map.put(qu, 0);
        }
        for (String str : strings) {
            if (str.length() < 1 || str.length() > 20)
                return null;
            Integer integer = map.get(str);
            if (integer != null) {
                map.put(str, ++integer);
            }
        }
        Collection<Integer> values = map.values();
        Object[] objects = values.toArray();
        System.out.println(objects);
        int[] res1 = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            res1[i] = Integer.valueOf(String.valueOf(objects[i]));
        }
        return res1;

    }
}
