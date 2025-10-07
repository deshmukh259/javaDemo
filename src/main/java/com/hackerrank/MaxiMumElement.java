package com.hackerrank;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaxiMumElement {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int k = Integer.valueOf(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<Integer>();
        //scanner.nextLine();
        int mx = Integer.MIN_VALUE;
        for (int i = k; i > 0; i--) {
            //String[] s1 = scanner.nextLine().split(" ");
//            int op = Integer.valueOf(s1[0]);
//            int val = s1.length > 1 ? Integer.valueOf(s1[1]) : 0;
        int op=scanner.nextInt();
        int val=scanner.nextInt();

            if (op == 1)
                stack.push(val);
            if (mx < val) mx = val;
            if (op == 2) {
                int pop = stack.pop();

            }
            if(!stack.isEmpty())mx =Collections.max(stack);
            if (op == 3) {
                System.out.println(mx);
            }
        }

    }
}
