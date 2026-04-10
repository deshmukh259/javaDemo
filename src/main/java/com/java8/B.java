package com.java8;

public class B {


    private static A a = A.getA();

    public static void main(String[] args) {
        Boolean b = null;
        if (!(b == null) && b) {
            System.out.println("true");
        } else {
            System.out.println(false);
        }
        a.disply();
    }

}
