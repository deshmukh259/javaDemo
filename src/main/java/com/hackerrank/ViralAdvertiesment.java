package com.hackerrank;

public class ViralAdvertiesment {


    // Complete the viralAdvertising function below.
    public static void main(String[] args) {
        int i = viralAdvertising(3);
        System.out.println(i);
    }

    static int viralAdvertising(int n) {

        int l = 2, s = 5;

        for (int i = 1; i < n; i++) {
            {
                //s = s + 3;
                s = (s / 2) * 3;
                l = (s / 2) + l;
            }

        }
        //System.out.println(s);
        return l;
    }
}
