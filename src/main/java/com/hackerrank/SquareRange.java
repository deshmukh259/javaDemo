package com.hackerrank;

public class SquareRange {

    public static void main(String[] args) {

        //squares(24, 49);
        System.out.println(squares(100, 1000));
    }

    static int arr[] = new int[1];

    static int squares(int a, int b) {

        boolean till = true;
        int count = 0;
        double sr = Math.sqrt(a);
        int x = (int) sr;
        double sub = sr - x;
        if (sub == 0) {
            count++;
        }
        int g = 0;
        for (int i = (int) Math.sqrt(a) + 1; till; i++) {

            g = i * i;
            if (g > b) {
                break;
            }
            count++;

        }
        return count-1;
    }

    static int squares1(int a, int b) {

        int count = 0;
        int v = 0;
        for (int i = a; i <= b; i++) {
            v = arr[i];
            if (v != 0) {
                count++;
                continue;
            }
            double sr = Math.sqrt(i);
            int x = (int) sr;
            double sub = sr - x;
            if (sub == 0) {
                arr[i] = x;
                count++;
            }
        }
        return count;
    }
}
