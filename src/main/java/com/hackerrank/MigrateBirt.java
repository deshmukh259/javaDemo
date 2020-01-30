package com.hackerrank;

import java.util.HashMap;
import java.util.List;

public class MigrateBirt {

    static int migratoryBirds(List<Integer> arr) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        arr.forEach(a -> {
            Integer o = hm.get(a);
            hm.put(a, o == null ? 1 : ++o);
        });
        final int[] max = {0};
        final int[] g = {0};
        hm.forEach((k, b) -> {
            if (max[0] < b) {
                max[0] = b;
                g[0] = k;
            }
        });
        return g[0];
    }
}
