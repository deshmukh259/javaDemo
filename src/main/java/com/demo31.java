package com;

import java.util.ArrayList;
import java.util.List;

public class demo31 {
    public static void main(String[] args) {
        System.out.println(104683731294243150l < Integer.MAX_VALUE);

        List<Integer> ll = new ArrayList<>();
        ll.add(5);
        ll.add(51);
        ll.add(52);
        ll.add(53);
        ll.add(54);
        System.out.println(ll);
        ll.retainAll(new ArrayList<>());
        System.out.println(ll);

    }
}
