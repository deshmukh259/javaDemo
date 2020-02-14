package com.hackerrank;

public class MinimumBridge {

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
    }

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        // q[0] = n if that n can be tranfer to its postion in 2 tranfer then check for other no

        int length = q.length;
        int h = 0;
        boolean b = false;
        for (int i = 0; i < length; i++) {

            int i1 = q[i];
            if (i1 - (i + 1) > 2) {
                b = true;
                break;
            //} else if (i1 != i + 1) {
            } else if (i1 - (i + 1) > 0) {
                int i2 = i1 - (i + 1);
                h += i2;
            }
        }
        if (b == true) {
            System.out.println("Too chaotic");
        } else
            System.out.println(h);


    }
}
