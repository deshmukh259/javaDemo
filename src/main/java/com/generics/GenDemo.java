package com.generics;

public class GenDemo {


    public static void main(String[] args) {

        String t = double1("55");
        System.out.println("GenDemo.main sum "+t);
    }

    private static <T> T double1(T t){
        return t;
    }
}
