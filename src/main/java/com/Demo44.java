package com;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Demo44 {

    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();

        map.put("g", new Person(5, 51, "EE"));

        map.put("e", new Person(4, 25, "DD"));

        map.put("a", new Person(3, 44, "CC"));

        List<Person> arr = new ArrayList<>();
        for (Map.Entry<String, Person> v : map.entrySet()) {
            Person value = v.getValue();
            value.setKey(v.getKey());
            arr.add(value);
        }

        Comparator<? super Person> comparator = Comparator.comparing(Person::getAge);
        Collections.sort(arr, comparator);

        LinkedHashMap<String,Person> linkedHashMap = new LinkedHashMap();

        for (Person person : arr) {
            linkedHashMap.put(person.getKey(), person);
        }

        for (Map.Entry<String, Person> v : linkedHashMap.entrySet()) {
            System.out.println(v.getKey()+" : "+v.getValue().getAge());
        }

        //linked hashmap

        // loop m

        // comparator based on age

//        id,age,name
//
//        map.put("e",new Person(4,25,"DD"));
//
//        map.put("a",new Person(3, 44, "CC"));
//
//        map.put("g",new Person(5, 51, "EE"));
//
//        25,4,,51
//
//        e,a,g

    }

}

@Setter
@Getter
class Person {

    int id;
    int age;
    String name;
    String key;

    public Person(int i, int i1, String cc) {
        this.id = id;
        this.age = i1;
        name = cc;
    }
    /**/
}


















