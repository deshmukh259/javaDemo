package com.hackerrank;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ArrayPair {

    static int sockMerchant(int n, int[] ar) {
        final Integer[] b = {0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i], map.get(ar[i]) == null ? 1 : map.get(ar[i]) + 1);
        }
        map.forEach((k, v) -> {
            if (v > 1) b[0] += v / 2;
        });
        return b[0];
    }
}
