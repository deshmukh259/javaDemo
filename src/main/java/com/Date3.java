package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date3 {
    public static void main(String[] args) {
        String s = "BBALLOCS_LowVol20190707";
//        int start =
//        int end =
//        System.out.println(s.substring(s.lastIndexOf("BBALLOCS"), s.indexOf("20")).replace("BBALLOCS","" ));
    }

    public static void main1(String[] args) {
        System.out.println(System.getProperty("line.separator"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current Date = " + calendar.getTime());

        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }
}
