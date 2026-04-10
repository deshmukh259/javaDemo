package com.hackerrank;

public class LillyBeautifulDays {


    public static void main(String[] args) {

    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {

        int g = 0;
        for (int l = i; l <= j; l++) {
            char[] chars = String.valueOf(l).toCharArray();
            char[] charsw = new char[chars.length];
            for (int m = 0, n = chars.length - 1; m < chars.length; m++, n--) {
                charsw[m] = chars[n];
            }
            int v = Integer.valueOf(String.valueOf(charsw));
            if ((l - v) % k == 0) g++;

        }
        return g;

    }

}
