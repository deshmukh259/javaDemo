package com.hackerrank;

import java.util.Scanner;

public class QueueUsingTwoStacks {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int l = scanner.nextInt();
        int arr[] = new int[l];
        int start = 0;
        int end = 0;
        scanner.nextLine();
        for (int i = 0; i < l; i++) {
            System.out.println("start: " + start + " end : " + end);
            String next = scanner.nextLine();
            String str[] = next.split(" ");

            int op = Integer.valueOf(str[0]);
            int val = str.length == 2 ? Integer.valueOf(str[1]) : 0;

            if (op == 1) { //add
                arr[start] = val;
                System.out.println("val :" + val + " arr: " + arr[start]);
                start++;
            }
            if (op == 2) { //remov
                end++;
            }
            if (op == 3) {//print
                if (end < arr.length) {
                    System.out.println(arr[end]);
                }
            }
            if (start == end) {
                start = 0;
                end = 0;
            }

        }

    }
}
