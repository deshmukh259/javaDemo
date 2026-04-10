package com.hackerrank;

public class DayOfProgrammer {

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(2017));
    }

    static String dayOfProgrammer(int year) {
        int g = 243;

        if ((year % 4 == 0) && year % 100 != 0)
        {
            g = 244;
        }
        else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0))
        {
            g = 244;
        }else if(year %4 ==0 && year >=1700 && year <1918 ){
            g = 244;
        }

        int i = 256 - g;
        return i + ".09." + year;


    }
}
