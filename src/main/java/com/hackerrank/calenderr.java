package com.hackerrank;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class calenderr {

    public static void main(String[] args) {
        //int day = 18, month = 12, year = 2019; // wed
        //12 25 2059
        int day = 25, month = 12, year = 2059;
        //int day = 5, month = 8, year = 2015; // wed ..
        //int day = 1, month = 1, year = 2019;//tues  ..
        //08 05 2015
        if (day > 0 && day < 32 && month > 0 && month < 13 && year > 2000 && year < 3000) {
            Calendar c = Calendar.getInstance();
            c.clear();
            c.set(year, month - 1, day, 0, 0, 0);
            int i = c.get(Calendar.DAY_OF_WEEK);

            Map<Integer, String> m = new HashMap();
            m.put(1, "SUNDAY");
            m.put(2, "MONDAY");
            m.put(3, "TUESDAY");
            m.put(4, "WEDNESDAY");
            m.put(5, "THURSDAY");
            m.put(6, "FRIDAY");
            m.put(7, "SATURDAY");
            System.out.println(m.get(i));
        }
    }
}
