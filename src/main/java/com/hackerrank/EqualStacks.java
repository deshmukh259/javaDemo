package com.hackerrank;

import java.util.Arrays;

public class EqualStacks {

    public static void main(String[] args) {

    }

    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        //  boolean

        return 0;
    }

    static int equalStacks1(int[] h1, int[] h2, int[] h3) {

        final int[] h11 = {0};
        Arrays.stream(h1).parallel().forEach(e -> h11[0] = h11[0] + e);
        int h1T = h11[0];

        h11[0] = 0;
        Arrays.stream(h2).parallel().forEach(e -> h11[0] = h11[0] + e);
        int h2T = h11[0];

        h11[0] = 0;
        Arrays.stream(h1).parallel().forEach(e -> h11[0] = h11[0] + e);
        int h3T = h11[0];

        int m = Math.max(Math.max(h1.length, h2.length), h3.length);

        int h1l = h1.length - 0;
        int h2l = h2.length - 0;
        int h3l = h3.length - 0;
        for (int i = 0; i < m; i++) {

            boolean b = h1T == h2T && h2T == h3T;
            if (b) {
                return h1T;
            }

            h3T = h3T - h3[h3l];


        }


        return 0;
    }
}
