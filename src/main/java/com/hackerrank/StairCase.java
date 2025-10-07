package com.hackerrank;

public class StairCase {


    public static void main(String[] args) {


        int n = 5;
        for (int i = n, h = 0; i > 0; i--) {
            int i1 = n - ++h;
            String b = i1 == 0 ? "" : String.format("%" + i1 + "s", "");
            String s = b + String.format("%1$" + h + "s", "").replace(' ', '#');
            System.out.println(s);
        }

    }
}
