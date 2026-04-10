package com.hackerrank;

public class HardleRace {

    static int hurdleRace(int k, int[] height) {

        int b = 0;
        int g = 0;
        for (int i = 0; i < height.length; i++) {
            if (g < height[i] ) {
                g = height[i];
                if (g>k) {
                    b = g - k;
                }
            }
        }
        return b;
    }
}
