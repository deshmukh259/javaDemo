package com.re;

public class FFuncational {

    public static void main(String[] args) {
        Calcu c = ( f, g)-> f+g;
        System.out.println("c.add(33,77) = " + c.doit(33,77));
        System.out.println("c.add(44,55) = " + c.doit(44,55));
    }
}

@FunctionalInterface
interface Calcu{
    int doit(int x,int v);
}
