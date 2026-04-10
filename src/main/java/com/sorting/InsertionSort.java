package com.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 8, 2, 6, 1, 45, 5, 1};
        a = insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int cc = a[i];
            while (a[j - 1] > cc && j > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = cc;
        }


        return a;
    }
}
