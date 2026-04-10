package com.hackerrank.linkedlist;

public class ArrayManuplution3 {


    public static void main(String[] args) {
        int a[][] = new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };

        a = new int[][]{
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };

        arrayManipulation(10, a);
    }


    // Complete the arrayManipulation function below.
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        if (n < 3 || n > 10000000 || queries.length < 1 || queries.length > 2 * 100000) {
            return 0;
        }

        int arr[] = new int[n];
        for (int[] item : queries) {
            arr[item[0]] += item[2];
            arr[item[1] + 1] -= item[2];
        }
        long sum = 0;
        for (int a : arr) {
            if ((a + sum) > sum) {
                sum = a + sum;
            }
        }

        System.out.println(sum);
        return sum;
    }


}
