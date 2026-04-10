package com.hackerrank.linkedlist;


public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagramm", "marganaa"));
        System.out.println(isAnagram("Hello", "hello"));
    }

    static boolean isAnagram(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();
        String temp = null;
        java.util.Map<Character, Integer> am = new java.util.HashMap<>();
        java.util.Map<Character, Integer> bm = new java.util.HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            final char f = a.charAt(i);
            am.put(f, (int) a.chars().filter(ch -> ch == f).count());
        }
        for (int i = 0; i < b.length(); i++) {
            final char f = b.charAt(i);
            bm.put(f, (int) b.chars().filter(ch -> ch == f).count());
        }
        if (am.size() != bm.size()) {
            return false;
        }

        for (java.util.Map.Entry<Character, Integer> me : am.entrySet()) {
            if (!me.getValue().equals(bm.get(me.getKey()))) return false;

        }
        return true;

    }
}
