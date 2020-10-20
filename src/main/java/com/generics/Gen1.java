package com.generics;

import java.util.List;

class Gen1 {
    static int[] a = {1, 2, 3,};

    static {
        //  a[2] ={1,2,3,};
        System.out.println("df" + a.length);

    }

    static int x, y;

    public static void main(String[] args) {
        int g = 10, m = 30;
        //StringBuffer
      /* // System.out.println("d"+g-m);
        Stack<Integer> s= new Stack<>();
        s.push(3);
        s.push(5);
        System.out.println(s);

        byte b=1;
        b++;
        StringBuffer v =new StringBuffer("a");
        v.append("12345678912345678");
        System.out.println(v.length());
        System.out.println(v.capacity());
       // System.out.println(null + true);//*/
        x--;
        m2();
        System.out.println(x + y + ++x);
//m1(null);
        boolean b = true;

        // if(b) return;

        System.out.println("");

        try {
            System.out.println("1");
            byte xx = 65;
        } catch (Exception e) {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }
        System.out.println("4");
    }

    public static void m2() {
        int g = 0;
        y = x++ + ++x;
    }

    private static void m1(Object o) {
        System.out.println("d");
    }


    private static void m1(String o) {
        System.out.println("sfsdf");
    }

    public static void add(List<Object> a) {
        a.add("c");

    }
}

class A {
    protected int c;

    A m() {
        System.out.println("AAAA");
        return null;
    }
}

class B extends A {
    B m() {
        System.out.println("bbb");
        return null;
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println('a' + "a");
        A aa = new B();
        aa.m();
    }
}
