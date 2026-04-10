package com.hackerrank;

public class AppleOrange {


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {


        if (a > s || s > t || t > b) return;
        if(s<0 || t<0 || a<0 || b <0 ) return;
        long app = 0, org = 0;
        int length = apples.length > oranges.length ? apples.length: oranges.length;
        for (int i = 0; i < apples.length; i++) {
            int i1 = apples[i] + a;
            if (s <= i1 && i1 <= t) {
                app++;
            }
        }
        for (int i = 0; i < oranges.length; i++) {
            int i1 = b + (oranges[i]);
            if (t <= i1 && i1 >= s) {
                org++;
            }
        }
        System.out.println(app);
        System.out.println(org);
    }
}

/*
*
      int apcount = 0;
        int orcount = 0;
        for (int i = 0; i < apples.length; i++) {
            apples[i] = apples[i] + a;
            if (s <= apples[i] && apples[i] <= t) {
                apcount += 1;
            }
        }
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = oranges[i] + b;
            if (s <= oranges[i] && oranges[i] <= t) {
                orcount += 1;
            }
        }
        System.out.println(apcount);
        System.out.println(orcount);
*
 for (int i = 0; i < length; i++) {
            if (apples.length > i) {
                int i1 = apples[i] + a;
                if (s <= i1 && i1 <= t) {
                    app++;
                }
            }
            if (oranges.length > i) {
                int i1 = b + (oranges[i]);
                if (t <= i1 && i1 >= s) {
                    org++;
                }
            }
        }
* */
