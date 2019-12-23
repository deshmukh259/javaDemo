package com.hackerrank.linkedlist;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<Integer>[] dy = new List[n];
        List<Integer> res = new ArrayList<>();

        if (n < 1 || n > 100000 || queries.size() < 1 || queries.size() > 100000) {
            return null;
        }
        int lastA = 0;

        for (List<Integer> integers : queries) {
            if (integers.get(1) < 0 || integers.get(1) > 1000000000 || integers.get(2) < 0 || integers.get(2) > 1000000000)
                return null;
            if (integers.get(0) == 1) {

                int ff = (integers.get(1) ^ lastA) % n;
                List v = dy[ff];
                if (v == null) {
                    v = new ArrayList<Integer>();
                }
                v.add(integers.get(2));
                dy[ff] = v;

            }
            if (integers.get(0) == 2) {

                int idx = (integers.get(1) ^ lastA) % n;
                int bb = (integers.get(2) % dy[idx].size());
                lastA = dy[idx].get(bb);
                System.out.println(lastA);
                res.add(lastA);


            }

        }
        return res;

    }

    public static void main(String[] args) {

        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1, 0, 5));
        queries.add(Arrays.asList(1, 1, 7));
        queries.add(Arrays.asList(1, 0, 3));
        queries.add(Arrays.asList(2, 1, 0));
        queries.add(Arrays.asList(2, 1, 1));

        List<Integer> integers = dynamicArray(n, queries);
        System.out.println(integers);

    }
}
