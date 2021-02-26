package com.java8;

interface CI {
    int g = 90;

    static void j() {
        System.out.println("in AI");
    }
}

@FunctionalInterface
interface DI {
    int g = 80;

    int f();

    static int j(int k) {
        System.out.println("in DI");
        return k;
    }
}

class DD implements CI, DI {


    @Override
    public int f() {
return 22;
    }
}

public class InterfaceFuncaionalDemo {
    public static void main(String[] args) {

        DI d = () -> {
            System.out.println("ddsd");
            return 55;
        };
        d.f();

        // a.j();
        //  int bb =  b-> 55;

    }
}
