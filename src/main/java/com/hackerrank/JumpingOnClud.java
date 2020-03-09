package com.hackerrank;

public class JumpingOnClud {

    public static void main(String[] args) {
        jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2);
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {

        int v = 100;
        //for (int i = 0; i < c.length; )
        int i = 0;
        do {
            i = i + k;
            i = i % c.length;
            System.out.println(i);
            if (i < c.length) {
                v -= c[i] == 0 ? 1 : 3;
            }
        } while (i % c.length != 0);
        return v;
    }


}
