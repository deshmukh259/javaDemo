package com;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo3 {
    public static final String FILE_DATE_FORMAT = "yyyyMMddHHmmss";

    public static void main(String[] args) {
        for (int i = 0;i<15;i++) {
            if(System.currentTimeMillis() == System.currentTimeMillis())
                System.out.println("true");
            else {
                System.out.println("false");
            }
        }

    }

    public static void main2(String[] args) {

        int[] bv = {1, 2, 3, 4};
        System.out.println(bv.toString());
        //  Character.siz
        BigDecimal b = new BigDecimal("700");
        System.out.println(b.toString().length());
//        "106938785"
//        "106923567 "
//                "106938785 "
//                        "106938785"
//                                "106938785 "
//                                        "106938785"

    }

    public static void main1(String[] args) {


        System.out.println(getFormatedNowTimestamp());

        if (null instanceof String) {
            System.out.println("hi");
        }
        System.out.println("ddd");

        Boolean b = false;

        cl(b);
        System.out.println(b);


    }

    private static String getFormatedNowTimestamp() {
        return new SimpleDateFormat(FILE_DATE_FORMAT).format(new Date());
    }

    private static void cl(Boolean b) {
        b = true;
    }
}
