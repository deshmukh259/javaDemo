package com.sorting;

public class SelectionSort {


    public static void main(String[] args) {
        int[] a = {1, 2, 8, 2, 6, 1, 45, 5, 1};
        a = selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] selectionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        return a;
    }
}
