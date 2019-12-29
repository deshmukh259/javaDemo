package com.hackerrank;

public class MInMax {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        int min=arr[0];
        int ii=arr[0];
        int max=arr[0];
        int jj=arr[0];
        for(int i=1;i<arr.length;i++){

            if(arr[i]< ii){
                ii= arr[i];
                min+= ii;
            }
            if(arr[i]> jj){
                jj= arr[i];
                max+= jj;
            }
        }
        System.out.println((min-arr[0])+" "+(max-arr[arr.length]));

    }

}
