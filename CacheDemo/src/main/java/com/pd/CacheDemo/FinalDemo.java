package com.pd.CacheDemo;

public class FinalDemo {


    public static void main(String[] args) {

        Fi c = new Fi(1, 5);
    }

}


class Fi {
    private final int a, b;


    Fi(int a, int b) {
        this.a = a;
        printb();

        this.b = b;
    }

    private void printb() {
        System.out.println(b);
    }
}