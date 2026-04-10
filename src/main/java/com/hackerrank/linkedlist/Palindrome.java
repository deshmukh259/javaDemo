package com.hackerrank.linkedlist;

public class Palindrome {
    public static void main(String[] args) {


        String A = "madam";
        boolean flg = true;
        char[] chars = A.toCharArray();
        for (int i = 0, j = A.length() - 1; i < (A.length() / 2); i++, j--) {
            if (chars[i] != chars[j]) {
                flg = false;
                break;

            }

        }
        if (flg)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
