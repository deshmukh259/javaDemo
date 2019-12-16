package com.hackerrank;

import java.util.Scanner;

public class formatting1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            String s3[] = s1.trim().split(" ");

            int x = sc.nextInt();
            if (x < 1000)

                System.out.println(String.format("%-15s%03d", s1, x));

        }
        System.out.println("================================");

    }
}
