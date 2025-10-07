package com.hackerrank;

public class AngryPropessor {

    public static void main(String[] args) {

    }

    static String angryProfessor(int k, int[] a) {


        for (int i = 0; i <a.length ; i++) {
            if(a[i] <=0) k--;
        }
        return  k>0?"YES":"NO";

    }
}
