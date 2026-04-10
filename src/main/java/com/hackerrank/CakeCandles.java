package com.hackerrank;

public class CakeCandles {

    static int birthdayCakeCandles(int[] ar) {

        int b=1,su=Integer.MIN_VALUE;
        for(int i=0 ;i<ar.length;i++){
            if(su <= ar[i]){
                if(ar[i] == su)
                    b++;
                su= ar[i];
            }
        }
        return b;

    }
}
