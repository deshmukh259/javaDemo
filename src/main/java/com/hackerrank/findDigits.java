package com.hackerrank;

public class findDigits {


    public static void main(String[] args) {
        findDigits(1012);
    }

    // Complete the findDigits function below.
    static int findDigits(int n) {

        int v = 0;
        int c = n % 10;
        int x = 1;
        do {
            if (n % c == 0) v++;
            x = (x * 10);
            c = n % x;
        } while (c > 0);

        return v;
    }

}
