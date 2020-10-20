package com.inheritance;

public class DemoInheritance {


    public static void main(String[] args) {

        DaoB b = new DaoB();
        b.setId(1);
        b.setName("Abcd");
        new B().r(b, 2);
    }
}
