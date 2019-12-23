package com.hackerrank.linkedlist;

public class LexiCal {

    public static void main(String[] args) {
        getSmallestAndLargest("welcometojava", 3);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        if (s.length() < k)
            return null;
        if (s.length() < 1 || s.length() > 1000)
            return null;
        boolean matches = s.matches(".*\\d.*");
        if (matches)
            return null;
        matches = s.matches(".*\\W.*");
        if (matches)
            return null;
        if (k < 0 || k > s.length())
            return null;
        smallest = largest = s.substring(0, k);
        for (int i = 0; i < s.length() - k + 1; i++) {

            String v = s.substring(i, i + k);
            if (smallest.compareTo(v) > 0)
                smallest = v;
            if (largest.compareTo(v) < 0)
                largest = v;

        }
        System.out.println(smallest + "\n" + largest);
        return smallest + "\n" + largest;
    }

}
