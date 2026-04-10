package com.hackerrank;

public class AppendAndDeleteString {


    public static void main(String[] args) {
      /*  String s1 = "hackerhappy";
        String s2 = "hackerrank";
        //9
        appendAndDelete(s1, s2, 9);*/

        String s1 = "ha";
        String s2 = "aaaaaaa00000000";
        //9
        System.out.println(appendAndDelete(s1, s2, 9));

    }

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        long v = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (i < t.length()) {
                char b = t.charAt(i);
                if (b != a)
                    k = k - 2;
                else {
                    v++;
                }
            } else {
                k--;
            }
        }
        int lengtht = t.length();
        int lengths = s.length();
        if (lengths < lengtht) {
            int bb = lengtht - lengths;
            k -= bb > 0 ? bb - v : 0;
        }
        System.out.println(k);
        return k > 0 ? "Yes" : "No";
    }
}
