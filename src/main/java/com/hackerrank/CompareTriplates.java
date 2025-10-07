package com.hackerrank;

import java.util.Arrays;
import java.util.List;

public class CompareTriplates {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int aa = 0, bb = 0;
        for (int i = 0; i < a.size(); i++) {

            if(a.get(i)> b.get(i)){
                aa++;
            }else if(b.get(i)> a.get(i)){
                aa++;
            }
        }
        return Arrays.asList(aa,bb);

    }

    public static void main(String[] args) {
        List a = Arrays.asList(5, 6, 7);
        List b = Arrays.asList(3, 6, 10);
        compareTriplets(a, b);


      String  s=   String.format("%5s","")+String.format("%1$" + 20 + "s", "").replace(' ', '#');
        System.out.println(s);

    }


}
