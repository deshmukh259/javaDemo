package com.hackerrank;

import java.util.Scanner;

public class printMultiple {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        if (N < 21 && N > 1) {
            for (int i = 1; i < 11; i++) {
                System.out.println(N + "*" + i + "=" + (N * i));
            }
        }

        scanner.close();
    }
}
