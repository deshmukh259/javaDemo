package com.lambda;

public class lambda1 {


    public static void main(String[] args) {

        F f= ()-> "hello";

        System.out.println("f.m() = " + f.m());
    }

}
@FunctionalInterface
interface F{
    String m();
}
