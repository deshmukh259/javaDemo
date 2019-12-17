package com.hack;

import java.util.Scanner;

public class FileRead {


    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        String s = null;
        while ((s = sc.nextLine()) != null) {
            System.out.println(++i + " " + s);
        }
    }
}
