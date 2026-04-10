package com.hackerrank;

public class InsertionSort {

    public static void main(String[] args) {

        int arr[] = new int[]{4 ,3 ,1, 2};
        int c=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <arr.length ; j++){
                if(arr[i] > arr[j]){
                   int g = arr[j];
                   arr[j]=arr[i];
                   arr[i]= g;
                   c++;
                }
            }
        }
        System.out.println(c);
    }


}
