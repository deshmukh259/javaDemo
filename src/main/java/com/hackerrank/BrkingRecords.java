package com.hackerrank;

public class BrkingRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int min = scores[0], m = 0;
        int max = scores[0], x = 0;
        for (int i = 1; i < scores.length; i++) {

            if (min < scores[i]) {
                m++;
                min = scores[i];
            }
            if (max > scores[i]) {
                x++;
                max = scores[i];
            }

        }
        return new int[]{m, x};

    }
}
