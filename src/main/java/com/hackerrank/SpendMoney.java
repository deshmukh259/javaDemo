package com.hackerrank;

public class SpendMoney {


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int max = -1;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int i1 = keyboards[i] + drives[j];
                if (i1 <= b && i1 > max) {
                    max = i1;
                }
            }
        }
        return max;
    }
}
