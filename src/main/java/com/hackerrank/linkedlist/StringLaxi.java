package com.hackerrank.linkedlist;

public class StringLaxi {

    public static void main(String[] args) {
        String A = "hello";
        String B = "java";
        char[] chars = A.toCharArray();
        Character c = chars[0];
        chars[0] = c.toString().toUpperCase().toCharArray()[0];
        A = String.valueOf(chars);

        chars = B.toCharArray();
        c = chars[0];
        chars[0] = c.toString().toUpperCase().toCharArray()[0];
        B = String.valueOf(chars);

        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(A + " " + B);


    }
}
