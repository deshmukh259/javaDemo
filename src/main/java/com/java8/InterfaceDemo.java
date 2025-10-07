package com.java8;

interface AI {
    int g =90;

    default void j(){
        System.out.println("in AI");
    }
}
interface BI {
    int g =80;

    default void j(){
        System.out.println("in BI");
    }
}

class D implements AI , BI{


    @Override
    public void j() {
      // j();
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {

        AI a= new D();
        a.j();

    }}
