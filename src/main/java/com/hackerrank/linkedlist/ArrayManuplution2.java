package com.hackerrank.linkedlist;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayManuplution2 {


    public static void main1(String[] args) {
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

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];
        int a[] = new int[n];
        long sum = Long.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int queriesItem = Integer.parseInt(queriesRowItems[0]);
            queries[i][0] = queriesItem;
            queriesItem = Integer.parseInt(queriesRowItems[1]);
            queries[i][1] = queriesItem;
            queriesItem = Integer.parseInt(queriesRowItems[2]);
            queries[i][2] = queriesItem;

            Arrays.fill(a, queries[i][0] - 1, queries[i][1], queries[i][0] - 1 + queries[i][2]);

    }
        for (int i = 0; i < a.length; i++) {
        if (a[i] > sum)
            sum = a[i];
    }
        System.out.println(sum);

        long result = sum;

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
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
