package com;


import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Date33 {

    public static void main(String[] args) throws ParseException {
        //2016-08-16T15:23:01
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        //Date parse = sf.parse("2016-08-16T15:23:01");

        //SimpleDateFormat sf1 = new SimpleDateFormat(
        //"yyyy-MM-dd'T'HH:mm:ssZ");
        // sf1.setTimeZone(TimeZone.getTimeZone("GMT"));
        //String format = sf1.format(parse);
        //System.out.println(format);
        LocalDateTime date1 = LocalDateTime.parse("2016-08-16T10:23:01",
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        //DateTimeFormatter.ISO_OFFSET_DATE_TIME
        //ZonedDateTime startZonedDT = ZonedDateTime.ofLocal(date1, ZoneOffset.of("+1"), null);
        ZonedDateTime startZonedDT = ZonedDateTime.ofLocal(date1, ZoneOffset.systemDefault(),null);
        System.out.println(startZonedDT.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        //System.out.println(startZonedDT.format(DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ss+00:00")));
        //Instant instant = date1.toInstant();
        //instant.atZone(ZoneId.of("UTC"));
        //String text = date1.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        //System.out.println(instant);
        //LocalDate parsedDate = LocalDate.parse(text, text);

    }
}
