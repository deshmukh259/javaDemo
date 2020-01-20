package com.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class Stackk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            Stack<Character> s1 = new Stack<>();
            Stack<Character> s2 = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                s1.add(input.charAt(i));

            }
            while (!s1.empty()) {
                char v = s1.pop();
                char f = s2.isEmpty() == true ? ' ' :s2.peek();
                if (f == ')' && v == '(') s2.pop();
                else if (f == '}' && v == '{') s2.pop();
                else if (f == ']' && v == '[') s2.pop();
                else s2.add(v);
            }
            if (s2.size() > 0)
                System.out.println(false);
            else
                System.out.println(true);
        }

    }
}
