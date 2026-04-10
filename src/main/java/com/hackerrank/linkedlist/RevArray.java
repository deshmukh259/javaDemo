package com.hackerrank.linkedlist;

public class RevArray {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {

        for (int i = 0, j = a.length - 1; i < a.length && a.length / 2 != i; i++, j--) {
            int v = a[j];
            a[j] = a[i];
            a[i] = v;

        }
        return a;

    }

    public static void main(String[] args) {
        int[] a = {1, 23, 4, 55, 77, 2};
        a = reverseArray(a);
        System.out.println(a.toString());

    }

}
