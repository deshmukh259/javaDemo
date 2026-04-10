package com.re;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Collectors2 {

    static List<Person> getList() {
        return Arrays.asList(new Person("Sara", 20),
                new Person("Bob", 33),
                new Person("Amol", 22),
                new Person("Sachin", 44),
                new Person("Purushottam", 25),
                new Person("Alen", 3),
                new Person("Ram", 22));
    }

    public static void main(String[] args) {
        getList().stream().filter(e -> e.getAge() > 1).forEach(System.out::println);

        Predicate<Person> vv = (Person v)-> v.getAge() <= 45;
        Predicate<Person> pre = (Person p) -> p.getAge() > 20;
        Function<? super Person, ?> function = (Person p) -> p.getAge();
        Consumer consumer = (i) -> System.out.println("age: " + i);
        getList().stream().filter(pre).map(function).forEach(consumer);


//        BinaryOperator<?> personBinaryOperator = (i,(total,age))-> i+total+age;
        int reduce = getList().stream().map(Person::getAge)
              //  .reduce(0, (total, age) -> total + age);
             //   .reduce(0, (total, age) -> Integer.sum(total , age));
                .reduce(0, Integer::sum);
        System.out.println("sum = " + reduce);

    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}