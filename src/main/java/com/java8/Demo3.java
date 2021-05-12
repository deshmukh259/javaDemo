package com.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo3 {

    public static void main(String[] args) {
        //[2,7,11,4] ,,target =9
        //
        int aa[] = new int[]{2, 7, 11, 4};
        Set ss = new HashSet();
        List list = new ArrayList();
        int target = 9;
        for (int i = 0; i < aa.length; i++) {
            if (!ss.contains(target - aa[i])) {
                ss.add(aa[i]);
            } else {
                list.add(target - aa[i] + " " + aa[i]);
            }
        }
        System.out.println(list);
    }
}
