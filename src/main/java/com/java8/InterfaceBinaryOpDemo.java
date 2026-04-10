package com.java8;


interface BOI {
    int f(int a, int b);
}


public class InterfaceBinaryOpDemo {


    public static void main(String[] args) {

        BOI c = (int a, int b) -> a * b;
        System.out.println(c.f(4, 5));

        System.out.println(b(""));
    }

    public static int b(Object v) {
        System.out.println("obj +" + v);
        return 55;
    }

    public static int b(String v) {

        try {
            System.out.println("strinh " + v);
            return 7;

        } catch (Exception e) {
            return 8;
        } finally {
            //    return 55;
        }

    }
}
