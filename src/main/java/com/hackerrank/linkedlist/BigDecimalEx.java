package com.hackerrank.linkedlist;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class BigDecimalEx {

    public static void main(String[] args) {
/*
* -100
0
0.000
0.12
0.12
2.34
9
50
56.6
90
* */

        String s[] = {
                "9",
                "-100",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000",
                null
        };
        s = new String[]{"2", null, "4..."};
        if (s.length < 1 || s.length > 200)
            return;
        final boolean[] flg = {false};
        Arrays.sort(s, new Comparator<String>() {
            public int compare(String o1, String o2) {


                if (o1 == null || o2 == null) return 1;
                if (o1.length() > 300 || o2.length() > 300)
                    flg[0] = true;
                BigDecimal b1 = new BigDecimal(o1);
                BigDecimal b2 = new BigDecimal(o2);
                if (b1.compareTo(b2) == 0) {
                    return 1;
                }


                if (b1.compareTo(b2) > 0) return -1;
                if (b1.compareTo(b2) < 0) return 1;
                return 1;
            }
        });
        if (flg[0]) return;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        /*System.out.println(new BigDecimal("000.000").toEngineeringString());
        System.out.println(new BigDecimal("0.12").toEngineeringString());
        System.out.println(new BigDecimal(".12").toEngineeringString());
        SortedMap<BigDecimal, String> bigD = new TreeMap<>(new Comparator<BigDecimal>() {
            public int compare(BigDecimal o1, BigDecimal o2) {
                if (o1 == null || o2 == null) return 1;
                if (o1.equals(o2)) {
                    return 0;
                }
                if (o1.compareTo(o2) > 0) return -1;
                if (o1.compareTo(o2) < 0) return 1;
                return 1;
            }
        });
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                bigD.put(new BigDecimal(s[i]), s[i]);
            }
         //   new BigDecimal().toString()
        }
        int i = -1;
        for (String s1 : bigD.values()) {
            s[++i] = s1;
            System.out.println(s[i]);
        }
*/

    }


}
/*
* BigDecimal bigD[] = new BigDecimal[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null) {
                bigD[i] = new BigDecimal(s[i]);
            }
        }
        Arrays.sort(bigD, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                if (o1 == null || o2 == null) return 1;
                if (o1.equals(o2)) {
                    return 0;
                }
                if (o1.compareTo(o2) > 0) return -1;
                if (o1.compareTo(o2) < 0) return 1;
                return 1;
            }
        });
        for (int i = 0; i < bigD.length; i++) {
            s[i] = bigD[i] != null ? (bigD[i].toPlainString()) : null;
            System.out.println(s[i]);
        }
* */