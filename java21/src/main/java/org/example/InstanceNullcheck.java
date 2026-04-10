package org.example;

public class InstanceNullcheck {

    public static void main(String[] args) {
        if (null instanceof String ){
            System.out.println("true");
        }else
            System.out.println("false");
    }
}
