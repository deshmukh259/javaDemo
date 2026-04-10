package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class PredicateDemo {

    public static void main(String[] args) {

        List<Lec> list = new ArrayList<>();
        list.add(new Lec("amol", 30));
        list.add(new Lec("sachin", 40));
        list.add(new Lec("gaja", 10));
        list.add(new Lec("sat", 32));
        list.add(new Lec("ram", 22));
        list.add(new Lec("om", 44));
        Predicate<Lec> p = (Lec l) -> l.getAge() > 30;
        Predicate<Lec> p2 = (n) -> n.getAge() < 30;

        Supplier<Lec> sup = () -> new Lec("Abhi", 21);
        list.add(sup.get());

        IntPredicate i = (v) -> v > 15;
        IntPredicate i30 = (v) -> v > 30;
        System.out.println("greater tha 15" + i.or(i30).test(5));
        display(list, "greater than 30", p);
        System.out.println("--------------");
        display(list, "less than 30", p2);

        Function<List<Lec>, List<Lec>> grt30LecList = (li) -> li.stream()
                .filter(l -> l.getAge() > 30).collect(Collectors.toList());

        System.out.println("function applied");
        for (Lec lec : grt30LecList.apply(list)) {
            System.out.println("name : " + lec.getName() + " age: " + lec.getAge());
        }
        BiFunction<String, List<Lec>, List<Lec>> bif = (str, list2) -> {
            System.out.println(str);
            list2.stream().filter(e -> e.getAge() > 10).forEach(f -> System.out.println(f.getName()));
            return list2;
        };
        bif.apply("BiFuncation",list);
    }

    private static void display(List<Lec> list, String namee, Predicate<Lec> condi) {

        System.out.println(namee);
        for (Lec l : list) {
            if (condi.test(l)) {
                System.out.println("name : " + l.getName() + " age: " + l.getAge());
            }
        }


    }
}


class Lec {
    private String name;
    private int age;

    public Lec(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}