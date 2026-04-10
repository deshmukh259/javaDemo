package com.java8;

interface AAI {
    int g = 90;

    static void j() {
        System.out.println("in AI");
    }
}

interface BBI {
    int g = 80;

    static void j() {
        System.out.println("in BI");
    }
}

class DDA implements AAI, BBI {


}

public class InterfaceStaticDemo {
    public static void main(String[] args) {

        AAI a = new DDA();
       // a.j();
        DDA v = (DDA) a;

    }
}
