package com.hackerrank;

public class FibonacciDIvideConqure {


    static int fibbo(int n) {

        if (n == 1) return 0;
        else if (n == 2) return 1;
        else {
            int fibbo = fibbo(n - 1);
            System.out.print((fibbo)+" ");
            int fibbo1 = fibbo(n - 2);
            System.out.print((fibbo1)+" ");
            return fibbo + fibbo1;
        }

    }

    public static void main(String[] args) {

        System.out.println(fibbo(6));


    }

}
