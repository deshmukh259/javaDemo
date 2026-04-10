package com.hackerrank;

public class CircularArrayRotation {


    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {


        for (int i = 0; i < k; i++) {
            int g = a[0];
            for (int j = 0; j < a.length; j++) {

                int v = a[j++];
                a[j] = g;
                g = a[j - 1];


            }

        }
        return a;
    }
}
