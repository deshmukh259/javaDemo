package com.hackerrank;

public class DiviableSumPai {
    static int divisibleSumPairs(int n, int k, int[] ar) {

        int c = 0;
        for (int i = 0; i < ar.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % 5 == 0)
                    c++;
            }
        }
        return c;
    }
}
