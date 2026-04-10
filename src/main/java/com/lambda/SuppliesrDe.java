package com.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SuppliesrDe {

    public static void main(String[] args) {
        Supplier<StringBuilder> sb = () -> new StringBuilder();

        System.out.println(sb.get().append("Abcd"));

        Consumer<StringBuilder> cc = v -> System.out.println(v);

        cc.accept(sb.get().append("Ancd"));


        List<String> v = List.of("Abcd","zxccc");

        Consumer<String> cons1 = c-> System.out.println("c = " + c);

        v.forEach(cons1);



    }

}
