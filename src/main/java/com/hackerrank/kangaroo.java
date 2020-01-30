package com.hackerrank;

public class kangaroo {
    public static void main(String[] args) {
        kangaroo(0, 2, 5, 3);


    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        if (x1 > x2 && v1 > v2) return "NO";
        if (x2 > x1 && v2 > v1) return "NO";

        long x11 = x1+v1, x22 = x2+v2;
        if(x11 == x22) return "YES";
        for (int i = 0; i < 1000; i++) {
            x11+=v1;
            x22+=v2;
            if(x11 == x22) return "YES";
        }
        return "NO";

    }
}
