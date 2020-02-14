package com.hackerrank;

public class ReapeatingString {


    public static void main(String[] args) {

    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long m = n / s.length();
        long h = 0;
        for (int i = 0; i < n - (m * s.length()); i++) {
            char v = s.charAt(i);
            if (v == 'a') {
                h++;
            }

        }
        String a = s.replace("a", "");
        return  ((s.length()-a.length())*m)+h;
    }
}
