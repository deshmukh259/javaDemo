package com.hackerrank.dp;

public class ConvertString {
static int xx =0;
    public static void main(String[] args) {

        System.out.println(convert("abczzxxssdd","acczzqwssxd"));
    }

    static int convert(String s1, String s2) {

        "Abc".replace("A","z");
        return flow(s1,s2,0,0);

    }

    static int flow(String s1, String s2, int a, int b) {
       // System.out.println(++xx);
        if (s1.length() == a)
            return s2.length() - b;
        if (s2.length() == b)
            return s1.length() - a;
        if (s1.charAt(a) == s2.charAt(b))
            return flow(s1, s2, a + 1, b + 1);
        int v = 1 + flow(s1, s2, a + 1, b);
        int n = 1 + flow(s1, s2, a, b + 1);
        int c = 1 + flow(s1, s2, a + 1, b + 1);
        return Math.min(Math.min(v, n), c);

    }
}
