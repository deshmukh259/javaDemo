package com.hackerrank;

public class CircularArrayRot2 {

    public static void main(String[] args) {
        circularArrayRotation(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1, null);
    }


    static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int[] t = new int[a.length];

        for (int i = 0, c = k; i < a.length; i++, c++) {
            if (c >= a.length) c = 0;
            t[c] = a[i];

        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = a[queries[i]];
        }
        return queries;


    }

    static int[] circularArrayRotation2(int[] a, int k, int[] queries) {


        int oldVal = a[0];
        int oldIndex = 0;
        for (int j = 0; j < a.length; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {


            for (int j = 0; j < k; j++) {
                oldIndex++;
                if (oldIndex >= a.length)
                    oldIndex = 0;
            }
            int newIndex = oldIndex;
            int newVal = a[newIndex];
            a[newIndex] = oldVal;
            oldVal = newVal;
            oldIndex = newIndex;

            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + a[j]);
            }
            System.out.println();

        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = a[queries[i]];
        }
        return queries;


    }

    static int[] circularArrayRotation1(int[] a, int k, int[] queries) {

        int oldVal = a[0];
        int oldIndex = 0;
        for (int j = 0; j < a.length; j++) {
            System.out.print(" " + a[j]);

        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {

            int newIndex = oldIndex + k;
            if (a.length - 1 < newIndex) {

                newIndex = newIndex % oldIndex;
                newIndex = newIndex - k - 1;
            }
            if (a.length - i == 1) {

                newIndex--;
                if (newIndex < 0) newIndex++;
            }
            int newVal = a[newIndex];

            a[newIndex] = oldVal;
            oldVal = newVal;
            oldIndex = newIndex;

            for (int j = 0; j < a.length; j++) {
                System.out.print(" " + a[j]);

            }
            System.out.println();

        }
        System.out.println(a);
        return a;
    }
}
