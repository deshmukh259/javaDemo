package com.hackerrank;

public class MinimumSwap {


    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{4, 3, 1, 2}));
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int c = 0;
        boolean f = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int g = arr[i];
                    arr[i] = arr[j];
                    arr[j] = g;
                    f = true;
                }

            }
            if (f == true) {
                c++;
                f = false;
            }
        }
        return c;
    }

    static long minimumSwaps1(long[] arr) {
        long r = 0, c = 0;
        /*for (long i = arr.length - 1; i > 0; i--) {

            long v = i + 1;
            // if (v == arr[i]) continue;
            long i1 = arr[i];
            if (i1 < arr.length) {
                long i2 = arr[i1];
                if (i1 < i2) {
                    arr[i] = i2;
                    arr[i1] = i1;
                    c++;
                }
            }
        }*/
        return c;


    }
}
