package com.hackerrank;

public class TowerOfHanoi {
    public static void main(String[] args) {
        move(3,'A','B','C');
    }

    public static void move(int n, char from, char mid, char to) {
        if (n == 1) {
            System.out.println("Plate 1 from :" + from + " to: " + to);
            return;
        }
        move(n - 1, from, to, mid);
        System.out.println("Plate " + (n) + " from :" + from + " to: "+to);
        move(n - 1, mid, from, to);

    }
}
