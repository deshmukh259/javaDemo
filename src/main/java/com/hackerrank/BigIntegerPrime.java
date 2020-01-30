package com.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerPrime {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String n = scanner.nextLine();
        BigInteger big1= new BigInteger("2");
// perform isProbablePrime on big1
// with certainty 1,0,-1
        if( big1.isProbablePrime (1) == true){
            System.out.println("prime");
        }else {
            System.out.println("not prime");

        }
        scanner.close();
    }
}
