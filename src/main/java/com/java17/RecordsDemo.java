package com.java17;

public class RecordsDemo {

    public static void main(String[] args) {
        Car1 c= new Car1(33,"ddd");
        System.out.println("c = " + c);
        System.out.println("c.carName() = " + c.carName());
        System.out.println("c.carNum() = " + c.carNum());
    }
}

 record Car1(int carNum,String carName){
    
} 
