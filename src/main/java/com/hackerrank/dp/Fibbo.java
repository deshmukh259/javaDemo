package com.hackerrank.dp;

import java.util.ArrayList;
import java.util.List;

public class Fibbo {
    static  long li[] = new long[6000];

    public static void main(String[] args) {
        System.out.println(fibbo(5000));

    }

    static long fibbo(int n) {

        if (li[n] == 0) {
            if (n == 1) return 1;
            if (n == 0) return 0;
            else li[n]=(fibbo(n - 1) + fibbo(n - 2));
        }
        return li[n];
    }
}
