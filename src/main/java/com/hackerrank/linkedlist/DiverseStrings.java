package com.hackerrank.linkedlist;

public class DiverseStrings {

    public static void main(String[] args) {


        int a[] = new int[10];

        String str = "";
        int l[] = new int[3];
        String let[] = new String[3];
        let[0] = "a";
        let[1] = "b";
        let[2] = "c";
        for (int i = 0; i < 10; i++) {
            int val = 0;
            String lt = null;
            int capIndex = 0;
            for (int j = 0; j < l.length - 1; j++) {
                int valT = l[j];
                String letT = let[j];

                int valTN = l[j + 1];
                String letTN = let[j + 1];

                if (valT == valTN)
                    continue;
                if (valT == valTN + 1) ;


            }

        }


    }
}
