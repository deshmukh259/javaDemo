package com.hackerrank;

public class MergeSOrt {

    public static void main(String[] args) {

        int a[] = new int[]{3, 6, 8, 9, 2, 1};

        a = mergersort(a, 0, a.length);


    }

    private static int[] mergersort(int[] a, int l, int r) {


        mergesort(a, new int[a.length], l, r-1);

        return a;

    }

    private static void mergesort(int[] a, int[] b, int l, int r) {

        if (l >= r) return;

        int m = (l + r) / 2;

        mergesort(a, b, l, m);
        mergesort(a, b, m + 1, r);

        merge(a, b, l, r);


    }

    private static void merge(int[] a, int b[], int l, int r) {


        int mid = (l + r) / 2;

        int k = mid + 1;
        int j = l;
        for (; j <= mid && k <= r; ) {
            if (a[j] <= a[k]) {
                b[j] = a[j];

            } else {
                b[j] = a[k++];
            }
            j++;
        }
        if (j > mid) {
            for (; k <= r; k++)
                b[j++] = a[k++];
        } else {
            if (k > r)
                for (; j <= mid; j++)
                    b[j] = a[j];
        }

        for(;l<=r;){

            a[l++] =b[l++];
        }


    }


}
