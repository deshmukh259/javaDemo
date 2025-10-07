package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        List v = new ArrayList();
        a.stream().forEach(x -> {
            //System.out.println(x);
            a.forEach(z -> {
                if (z > x) {
                    if (z - x <= 1) {
                        v.add(z);
                    }
                }
                if (x > z) {
                    if (x - z <= 1) {
                        v.add(z);
                    }
                }

            });
        });
        return v.size();

    }
}
