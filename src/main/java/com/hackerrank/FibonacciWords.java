package com.hackerrank;

import java.util.LinkedList;
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
            //c.ch
            LinkedList<Character> list = new LinkedList<>();
            for (long l = 0; l < c.length(); l++) {
                //list.add()
            }
            //System.out.println(s.get(n-1));
            StringBuilder sb = new StringBuilder(c);
            //while (sb)

        }

    }
}
