package com.hackerrank;

public class MergeSOrt2 {

    public static void main(String[] args) {

        int a[] = new int[]{1, 5, 2, 7, 6};

        sort1(a);

    }

    private static void sort1(int[] a) {


        mergeSort(a, new int[a.length], 0, a.length - 1);

    }

    private static void mergeSort(int[] a, int[] temp, int leftStart, int rightEnd) {


        if (leftStart >= rightEnd) return;

        int mid = (leftStart + rightEnd) / 2;
        mergeSort(a, temp, leftStart, mid);
        mergeSort(a, temp, mid + 1, rightEnd);

        merge(a, temp, leftStart, rightEnd, mid);


    }

    private static void merge(int[] a, int[] temp, int leftStart, int rightEnd, int mid) {

        int left = leftStart;
        int rightSart = mid + 1;
        int leftEnd = mid;
        int leftL = leftStart;


        for (; left <= leftEnd && rightSart <= rightEnd; ) {

            if (a[left] <= a[rightEnd]) {
                temp[leftL] = a[left];
                left++;

            } else {
                temp[left] = a[rightSart];
                rightSart++;
            }
            leftL++;
        }

        if (left > leftEnd) {
            for (; rightSart <= rightEnd; ) {
                temp[leftL++] = a[rightSart++];
            }
        } else {
            if (rightSart > rightEnd) {
                for (; left <= leftEnd; ) {
                    temp[leftL++] = a[left++];
                }
            }
        }


        for (left = leftStart; left <= rightSart; ) {
            a[left] = temp[left];
            left++;
        }
        System.out.println("----");

    }
}
