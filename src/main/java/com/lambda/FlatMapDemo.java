package com.lambda;

import java.util.ArrayList;
import java.util.List;

public class FlatMapDemo {

    public static void main(String[] args) {
        List<Parent> parents = new ArrayList<>();
        Parent e = new Parent();
        e.setName("P1");
        e.getChildList().add(new Child("C1", 11));
        e.getChildList().add(new Child("C2", 12));
        e.getChildList().add(new Child("C3", 13));
        e.getChildList().add(new Child("C4", 14));
        parents.add(e);
        parents.stream()
                .flatMap(u -> e.getChildList()
                        .stream()).forEach(d -> System.out.println(d.getName()));
    }
}

class Parent {
    private String name;
    private List<Child> childList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

}

class Child {
    private String name;
    private int age;

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

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }
}