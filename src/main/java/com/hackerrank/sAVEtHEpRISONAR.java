package com.hackerrank;

public class sAVEtHEpRISONAR {
    public static void main(String[] args) {
        System.out.println(saveThePrisoner(3, 7, 3));
    }

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {

        int vv = m > n ? m % n : m;
        int nn = vv + s;
        if (nn > n) {
            return nn - n+s;
        } else
            return nn;
    }
}
