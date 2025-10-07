package com.hackerrank;

import java.util.List;

public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {

        int c = 0;
        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            for (int j = i, k = 0; k < m && j < s.size(); k++, j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                c++;
            }
        }
        return c;
    }

}
