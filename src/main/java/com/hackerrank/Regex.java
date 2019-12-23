package com.hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String p = "\\d\\d\\d.\\d\\d\\d.\\d\\d\\d.\\d\\d\\d";
        String[] in = new String[3];
        in[0] = "000.12.12.034";
        in[1] = "121.234.12.12";
        in[2] = "23.45.12.56";

        for (int i = 0; i < in.length; i++) {
            String ip = in[i];
            Pattern r = Pattern.compile(p);
            Matcher m = r.matcher(ip);
            System.out.println(m.find());
            System.out.println(m.group());
        }

    }
}
