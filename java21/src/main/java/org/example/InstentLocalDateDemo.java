package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class InstentLocalDateDemo {

    public static void main(String[] args) {
        String startDate = "2025-05-24";
        String endDateDate = "2025-05-26";

        System.out.println(LocalDate.parse(startDate).atTime(LocalTime.MIN).toInstant(ZoneOffset.UTC).toString());
        System.out.println(LocalDate.parse(endDateDate).atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC).toString());
    }
}
