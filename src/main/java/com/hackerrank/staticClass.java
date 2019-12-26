package com.hackerrank;


import java.util.Scanner;

public class staticClass {
    static int H, B;
    static boolean flag = false;

    static {
        Scanner sc = new Scanner(System.in);
        try {
            B = sc.nextInt();
            H = sc.nextInt();

            if (B < 0 || H < 0)
                throw new RuntimeException();
            flag = true;
            if (B > 100 || H > 100 || B == 0 || H == 0)
                flag = false;


        } catch (RuntimeException e) {
            try {
                throw new Exception("Breadth and height must be positive");
            } catch (Exception ex) {
                System.out.println(ex);

            }
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
