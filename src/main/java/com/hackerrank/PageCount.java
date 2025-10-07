package com.hackerrank;

public class PageCount {

    static int pageCount(int n, int p) {

        if(n%2==0){
            n++;
        }
        int m = n / 2;
        if (m > p) {
            // from start
            return p / 2;
        } else {
            return (n-p)/2;
        }

    }
}
