package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        try {
            int b = 4 / 0;
        } catch (Exception e) {
            System.out.println(e.getCause().getMessage());
        }
    }

    public static void main1(String[] args) {

        try {
            System.out.println(System.currentTimeMillis());
            int i = 3434343;
            BigDecimal b = new BigDecimal("12");
            b = b.add(new BigDecimal(55));

            System.out.println(b.compareTo(new BigDecimal(0)) <= 0);

            System.out.println("big " + b);

            String dd = " assssswwss";
            dd = " hello " + dd;
            System.out.println(dd);

            List<String> l = new ArrayList<>();
            l.add("s");
            l.add("d");
            String j = "";
            for (String s : l) {
                j = s;
            }
            System.out.println(j);

            String s = " hi";
            throw new RuntimeException(" run....");
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("1nd " + e);
            throw e;
        } catch (Throwable e) {
            System.out.println("2nd " + e);
        }
        System.out.println("ddddddddddddddddd");

    }
}
