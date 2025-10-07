package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TImeConv {

    static String timeConversion(String s) {

        //s =
        System.out.println(s);
        boolean f = s.contains("AM") ? false : true;
        s = s.replace("PM", "");
        s = s.replace("AM", "");
        String[] split = s.split(":");

        String v = f == true ? String.valueOf(Integer.valueOf(split[0]) + 12) : (split[0]);
        v = f == true && Integer.valueOf(split[0]) == 12 ? String.valueOf(Integer.valueOf(split[0])) : v;
        v = f == false && Integer.valueOf(split[0]) == 12 ? String.valueOf("00") : v;
        System.out.println(String.format("%02d:%02d:%02d", Integer.valueOf(v), Integer.valueOf(split[1]), Integer.valueOf(split[2])));
        return null;

    }

    public static void main(String[] args) {

        List<String> ll = new ArrayList<>();
        ll.add("10");
        ll.add("10");
        ll.add("1");
        ll.add("1");
        ll.add("1");
        ll.add("1");
        ll.add("1");
        ll.add("10");
        ll.add("10");
        ll.add("10");

        combination(ll,ll.size()/2," ");


      /*  String[] ss = {"07:05:45PM",
                "12:12:44AM", "12:12:44PM", "00:00:44AM", "22:0:44PM"};
        for (int i = 0; i < ss.length; i++) {

            timeConversion(ss[i]);
        }*/
    }

    public static void main1(String[] args) {
        String s = "";
        int hours = Integer.parseInt(s.substring(0, 2));
        String timeZ = s.substring(8, 9);
        if (timeZ.equals("A")) {
            if (hours == 12)
                hours = 00;
        } else if (timeZ.equals("P")) {
            if (hours != 12)
                hours = hours + 12;
        }

        String hourD = String.format("%02d", hours);
        // hourD + s.substring(2, 8);
    }


    public static void combination(List<String> e, int k, String accumulated) {

        // 1. stop
        if (e.size() < k)
            return;

        // 2. add each element in e to accumulated
        if (k == 1)
            for (String s : e)
                System.out.println(accumulated + s);

            // 3. add all elements in e to accumulated
        else if (e.size() == k) {
            for (String s : e)
                accumulated += s;
            System.out.println(accumulated);
        }

        // 4. for each element, call combination
        else if (e.size() > k)
            for (int i = 0; i < e.size(); i++)
                combination(e.subList(i + 1, e.size()), k - 1, accumulated + e.get(i));

    }
}
