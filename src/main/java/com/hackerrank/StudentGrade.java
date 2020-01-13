package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class StudentGrade {


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(73);
        a.add(67);
        a.add(38);
        a.add(33);
        a = gradingStudents(a);
        System.out.println(a);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < 38) continue;

            int v = grades.get(i);
            grades.remove(i);
            int c = (v / 5 + 1)*5 - v;
            int b = c < 3 ? v + c : v;
            grades.add(i,b);

        }
        return grades;

    }

}
