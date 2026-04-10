package com.hackerrank;

public class LeftRotationArray {

    public static void main(String[] args) {

    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {


        for (int i = 0; i < d; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                //swap
                int v = a[j];
                a[j] = a[j + 1];
                a[j + 1] = v;

            }
        }
        return a;
    }
}
