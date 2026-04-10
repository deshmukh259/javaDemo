package com.hackerrank;

public class SecMax_Imp {


    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 6, 8, 22, 44, 12, 23, 25};

        int[] b = new int[2 * a.length - 1];
        for (int i=8; b.length>i;i++){
            b[i]=a[(8-i)*-1];
        }
        a=b;
        for (int i = a.length - 1; i > 0; i--) {

            int v = i;
            int x = --i;
            b[x/2]= a[v]>a[x] ? a[v]:a[x];
        }
        System.out.println("sec "+b[6]);


    }

}
