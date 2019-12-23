package com.hackerrank.linkedlist;

public class ArrayManuplution {


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

        int a[] = new int[n];
        for (int i = 0; i < queries.length; i++) {

            for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
                if (queries[i][1] < 1 || queries[i][1] > n ||
                        queries[i][0] < 1 || queries[i][0] > n ||
                        queries[i][2] < 0 || queries[i][2] > 1000000000)
                    return 0;
                int i1 = a[j] + queries[i][2];

                a[j] = i1;

            }
        }
        long sum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > sum)
                sum = a[i];
        }
        System.out.println(sum);
        return sum;
    }


}
