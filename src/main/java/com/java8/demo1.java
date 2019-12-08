package com.java8;

interface I1 {
    int f1(int i);
}
//
//class D1 implements I1 {
//
//    @Override
//    public void f1(int e) {
//        System.out.println("helloo " + e);
//        return e;
//    }
//}


public class demo1 {

    public static void main(String[] args) {
        I1 i = e -> e + 100;
        int v = i.f1(448);
        System.out.println(v);

    }

}

