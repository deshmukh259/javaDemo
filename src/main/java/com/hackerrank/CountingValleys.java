package com.hackerrank;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        long b = 0;
        long k = 0;
        long j = 0;
        for (int i = 0; i < s.length(); i++) {

            boolean b1 = s.charAt(i) == 'U';
            if (b1) {
                b++;
            } else {
                b--;
            }
            if (b == 0 && b1 == true) {
                k++;
            }



        }
        return (int) (k);

    }

    public static void main(String[] args) {

    }
}
