package com.hackerrank;

import java.util.List;

public class BonAppetit {

    static void bonAppetit(List<Integer> bill, int k, int b) {
        double s = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (k == i) continue;
            s = s + (double)bill.get(i) / 2.0;
        }
        if (b == s) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b);

        }


    }
}
