package com.java8;

class A implements Cloneable {
    private static A a = new A();

    private A() {

    }

    protected Object readResolver() {

        return a;
    }

    public Object clone() {
        return a;

    }

    public void disply() {

        System.out.println("A dispaly methos called");

    }

    public static A getA() {
        return a;
    }


}

