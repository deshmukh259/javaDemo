package com.lambda;

public class UpperClassLambda {
    public static void main(String[] args) {


        //UpperCase uc = (String a,String b) -> a.toUpperCase()+b.toUpperCase();
        UpperCase uc = (a, b) -> a.toUpperCase() + b.toUpperCase();

        System.out.println(uc.upper("abcd", "dxddf"));
    }


}

interface UpperCase {

    String upper(String a, String b);
}