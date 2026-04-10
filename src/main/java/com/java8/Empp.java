package com.java8;

import java.util.ArrayList;
import java.util.List;

public class Empp {
    int id;
    String name;
    String add;
    String cls;
    int grade;

    public Empp(int id, String name, String add, String cls, int grade) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.cls = cls;
        this.grade = grade;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Empp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", add='" + add + '\'' +
                ", cls='" + cls + '\'' +
                ", grade=" + grade +
                '}';
    }

    public static List<Empp> empList = new ArrayList<>();

    static {
        empList.add(new Empp(1, "PD", "UK", "11", 80));
        empList.add(new Empp(2, "A", "K", "11", 80));
        empList.add(new Empp(3, "B", "UK", "11", 40));
        empList.add(new Empp(4, "C", "UK", "11", 40));
        empList.add(new Empp(5, "D", "UK", "11", 40));
        empList.add(new Empp(6, "E", "UK", "11", 40));
        empList.add(new Empp(7, "F", "UK", "11", 85));
        empList.add(new Empp(8, "G", "UK", "11", 85));
        empList.add(new Empp(9, "H", "UK", "11", 85));
        empList.add(new Empp(10, "I", "UK", "11", 80));
        empList.add(new Empp(11, "J", "AK", "11", 80));
        empList.add(new Empp(12, "K", "AK", "11", 80));
        empList.add(new Empp(13, "L", "AK", "11", 80));
        empList.add(new Empp(14, "M", "UzK", "11", 50));
        empList.add(new Empp(15, "N", "UzK", "11", 50));
        empList.add(new Empp(16, "O", "UxK", "11", 50));
        empList.add(new Empp(17, "P", "UxK", "11", 50));
        empList.add(new Empp(18, "Q", "UxK", "11", 50));
        empList.add(new Empp(19, "R", "UxK", "11", 50));
        empList.add(new Empp(21, "T", "AUK", "11", 70));
        empList.add(new Empp(22, "U", "AUK", "11", 70));
        empList.add(new Empp(20, "S", "AUK", "11", 70));
    }
}
