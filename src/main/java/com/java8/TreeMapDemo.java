package com.java8;

import java.util.Map;
import java.util.TreeMap;

class E {
    private int id;
    private String s;

    public E(int id, String s) {
        this.id = id;
        this.s = s;
    }

    @Override
    public String toString() {
        return "E{" +
                "id=" + id +
                ", s='" + s + '\'' +
                '}';
    }
}

public class TreeMapDemo {

    public static void main(String[] args) {
        E a = new E(1, "w");
        E b = new E(2, "c");
        E c = new E(3, "d");
        Map v = new TreeMap<E, E>();
        v.put(a, a);
        v.put(b, b);
        v.put(c, c);
        System.out.println(v);

    }
}
