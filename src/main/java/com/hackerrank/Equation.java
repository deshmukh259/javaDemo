package com.hackerrank;

import java.util.Scanner;

public class Equation {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int s = 0;
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            s = a + 1 * b;
            System.out.print(s + " ");
            for (int j = 1; j < n; j++) {

                int x = (int) (Math.pow(2, j) * b);
                s = s + x;
                System.out.print(s + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
