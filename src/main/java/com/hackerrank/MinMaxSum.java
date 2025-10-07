package com.hackerrank;

public class MinMaxSum {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        if (arr == null || arr.length == 0) return;
        if (arr.length > 5) return;
        System.out.println(Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int h = 0, n = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 100000000) return;
            h += arr[i];
            n -= arr[i];
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(Math.abs(n + max) + " " + Math.abs(h - min));
    }

}
