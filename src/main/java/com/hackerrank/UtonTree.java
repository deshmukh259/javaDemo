package com.hackerrank;

public class UtonTree {

    public static void main(String[] args) {

    }

    static int utopianTree(int n) {

        if (n == 0) return 1;
        if (n == 1) return 2;
        int v = 2;

        for (int i = 2; i <= n; i++) {
            v = i % 2 != 0 ? v * 2 : v + 1;
        }
        return v;

    }

}
