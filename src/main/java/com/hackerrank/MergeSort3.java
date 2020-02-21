package com.hackerrank;

import java.util.Arrays;

public class MergeSort3 {

    public static void main(String[] args) {


        int arr[] = new int[]{6, 5, 7, 7, 8, 4, 2, 1,4,2,55,66,33,5,7,100,87,33};

        sort1(arr, new int[arr.length]);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sort1(int[] arr, int[] ints) {

        mergeSort(arr, ints, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] ints, int leftStart, int rightEnd) {

        if (leftStart >= rightEnd) return;

        int mid = (leftStart + rightEnd) / 2;
        System.out.println(String.format(" 1 lefftstart %d mid %d rightend %d ", leftStart, mid, rightEnd));
        mergeSort(arr, ints, leftStart, mid);
        System.out.println(String.format(" 2 lefftstart %d mid %d rightend %d ", leftStart, mid + 1, rightEnd));
        mergeSort(arr, ints, mid + 1, rightEnd);
        System.out.println(String.format(" 3 lefftstart %d mid %d rightend %d ", leftStart, mid, rightEnd));
        merge(arr, ints, leftStart, rightEnd, mid);

    }

    private static void merge(int[] arr, int[] ints, int leftStart, int rightEnd, int mid) {

        int leftt = leftStart;
        int leftend = mid;
        int rightStart = mid + 1;
        int leftT = leftStart;

        while (leftt <= leftend && rightStart <= rightEnd) {

            if (arr[leftt] >= arr[rightStart]) {
                ints[leftT] = arr[rightStart++];

            } else {
                ints[leftT] = arr[leftt++];
            }

            leftT++;
        }
        if (leftt > leftend) {
            while (rightStart <= rightEnd) {
                ints[leftT] = arr[rightStart];
                leftT++;
                rightStart++;
            }
        } else if (rightStart > rightEnd) {
            while (leftt <= leftend) {
                ints[leftT] = arr[leftt];
                leftt++;
                leftT++;
            }
        }

        while (leftStart <= rightEnd) {
            arr[leftStart] = ints[leftStart++];
        }
        System.out.println("-------------");
    }
}
