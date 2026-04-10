package com.hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Hashmap {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        String v = null;
        HashSet<String> hs =new HashSet<>();
        for (int i = 0; i < t; i++) {
            hs.add(pair_left[i].toLowerCase()+pair_right[i].toLowerCase());
            System.out.println(hs.size());
        }
    }
}
