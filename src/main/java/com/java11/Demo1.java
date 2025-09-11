package com.java11;

public class Demo1 {

    public static void main(String[] args) {

        var v = 10;{
            var g=44;
            System.out.println("g = " + g);
            var var = 88;
            System.out.println("var = " + var);
        }
        System.out.println(v);
        A a = new B();
        System.out.println("a. = " );
    }

}
interface A{

    private static int getInt(int b){
        return b*b;
    }
    static int getI(int b){
        return getInt(b);
    }
}
class B implements A {

    int get(){

        return 55;
    }
}