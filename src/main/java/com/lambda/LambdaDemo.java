package com.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {

    public static void main(String[] args) {

        List<Empy> empyList = new ArrayList();
        empyList.add(new Empy("Pd", 21));
        empyList.add(new Empy("Anand", 30));
        empyList.add(new Empy("Sachin", 21));
        empyList.add(new Empy("Amol", 21));
        empyList.forEach(e -> System.out.println(e.getName()));
     //   Collections.sort(empyList, (a, b) -> a.getName().compareTo(b.getName()));
      //  Collections.sort(empyList, Comparator.comparing(Empy::getName));
        empyList.sort(Comparator.comparing(Empy::getName));

        System.out.println("after----");
        empyList.forEach(e -> System.out.println(e.getName()));

    }
}

class Empy {
    private String name;
    private int age;

    public Empy(String name, int age) {
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
