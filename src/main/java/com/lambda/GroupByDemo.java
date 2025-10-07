package com.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDemo {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("dog", "M", 3));
        animals.add(new Animal("dog2", "F", 5));
        animals.add(new Animal("cat", "M", 13));
        animals.add(new Animal("cat2", "F", 2));
        animals.add(new Animal("ox", "M", 15));
        animals.add(new Animal("Caw", "F", 16));
        animals.add(new Animal("Dear", "M", 5));
        animals.add(new Animal("Dear", "M", 5));
        animals.add(new Animal("Dear", "F", 5));

        Map<String, List<Animal>> collect = animals.stream()
                .collect(Collectors.groupingBy(Animal::getSex));
        collect.forEach((f,n)->System.out.println(f+" "+n));
    }

}

class Animal {

    private String name;
    private String sex;
    private int age;

    public Animal(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
