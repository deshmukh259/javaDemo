package com.hackerrank.linkedlist;

public class ArrayRotation {


    public static void main(String[] args) {


        int n = 5;

        int d = 4;
        int[] a = new int[n + d];

        String[] aItems = "1 2 3 4 5".split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (aItems.length < 1 || aItems.length > 100000) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        if (a.length < 1 || a.length > 100000 || d < 1 || d > a.length) {
            return;
        }
        int t = Integer.MIN_VALUE;
        for (int i = 0; i < d; i++) {
            a[n + i] = a[i];
            a[i] = 0;
        }
        for (int i = d; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
/*
*
* import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n+d];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        if (a.length < 1 || a.length > 100000 || d < 1 || d > a.length) {
            return;
        }
        int t = Integer.MIN_VALUE;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (t == Integer.MIN_VALUE) {
                    t = a[j];
                }
                a[j] = a[j + 1];

            }
            a[a.length - 1] = t;
            t = Integer.MIN_VALUE;

        }
        for (int i = 0; i < a.length; i++) {
            System.out.print( a[i]+" " );
        }

        scanner.close();
    }
}

* */
}
