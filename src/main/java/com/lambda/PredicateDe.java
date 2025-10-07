package com.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDe {

    public static void main(String[] args) {

        int x = 5;
        System.out.println("x = " + x + " is even = " + check(x, c -> c % 2 == 0));
        x = 90;
        System.out.println("x is odd  " + check(x, c -> c % 2 == 0));


        System.out.println("contianis "+  contains("Abcd", s->s.contains("A")));

        System.out.println("Bi pre is contains "+containss("Abcd","c",(a,b)->a.contains(b)));
    }

    public static <T,U>boolean containss(T t, U u, BiPredicate<T,U> bi){
        return bi.test(t,u);
    }
    public static <T>boolean contains(T t, Predicate<T> lam){
        return lam.test(t);
    }
    public static <T> boolean check(T t, Predicate<T> lam) {
        return lam.test(t);
    }
}
