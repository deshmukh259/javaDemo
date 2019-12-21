package com.hackerrank.linkedlist;

public class Hourglass {

    public static void main(String[] args) {
       /* int a[][] = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };*/

        int a[][] = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int b[][] = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        int sum = hourglassSum(a);
        System.out.println(sum);
        sum = hourglassSum(b);
        System.out.println(sum);
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
            int s = Integer.MIN_VALUE;
            int length = arr[0].length;
            for (int jj = 0; jj < 4; jj++) {
                for (int ii = 0; ii < 3; ii++) {
                    if (!(arr[jj][ii] > -10 && arr[jj][ii] < 10)) {
                        return 0;
                    }
                }
            }
                for (int j = 0; j < arr.length-2; j++) {
                    for (int i = 0; i < arr[0].length-2; i++) {
                        if (!(arr[j][i] > -10 && arr[j][i] < 10) ||
                                !(length > -1 && length < 7) ||
                                !(arr.length > -1 && arr.length < 7)) {
                            return 0;
                        }
                        int t = (arr[j][i] + arr[j][i + 1] + arr[j][i + 2])
                                + (arr[j + 1][i + 1]) +
                                (arr[j + 2][i] + arr[j + 2][i + 1] + arr[j + 2][i + 2]);
                        if (t > s) {
                            s = t;
                        }

                    }
                }
                return s;

            }
    }
