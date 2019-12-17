package com.hack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FibonacciWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i1 = Integer.valueOf(sc.nextLine());
        String dd[] = new String[i1];
        for (int j = 0; j < i1; j++) {
            dd[j] = sc.nextLine();
        }
        for (int jj = 0; jj < i1; jj++) {
            String[] bb = dd[jj].split(" ");
            String a = bb[0];
            String b = bb[1];
            long n = Long.valueOf(bb[2]);
            long q = n % 10;
            String c = "";

            for (int i = 0; i < q - 1; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            char[] chars = c.toCharArray();
            List s = Arrays.asList(c.toCharArray());
            System.out.println(s.get(n-1));
        }

    }
}
