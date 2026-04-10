package com.hackerrank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Try {

    public static void main(String[] args) {
        try {
            try {
                Scanner scanner = new Scanner(System.in);
                long a = scanner.nextLong();
                long b = scanner.nextLong();
                if( a< 0 || b< 0 || a > Integer.MIN_VALUE || b > Integer.MAX_VALUE)
                    throw new InputMismatchException();
                System.out.println(a / b);
            } catch (InputMismatchException e) {
                throw e;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
