package com;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Date1 {

    public static void main(String[] args) {
        //System.out.println(new Date((LocalDateTime.now().minusDays(2).withHour(22).withMinute(59).withSecond(0).toLocalDate()));
        System.out.println(Math.round(Float.valueOf("2.8")));
       /* Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.HOUR_OF_DAY, 4);
        System.out.println(new Date(c.getTimeInMillis()));*/
    }
}
