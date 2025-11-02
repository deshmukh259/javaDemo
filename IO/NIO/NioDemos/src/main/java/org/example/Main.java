package org.example;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");


        File f1 = new File("/Users/apple/clone/javaDemo/IO/NIO/NioDemos/src/main/resources/");

        File f2 = new File(f1,"text1.txt");

        System.out.println(f2.exists());
        System.out.println(f2.isDirectory());

        f2.createNewFile();






    }
}