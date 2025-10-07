package com.inheritance;

public class B extends A {

    public void r(DaoB c, int b) {
        super.r(c, b);
        System.out.println("B method " + c.getName());
    }
}
