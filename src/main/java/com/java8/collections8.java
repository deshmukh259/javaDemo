package com.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class collections8 {

    public static void main(String[] args) {
        HashMap<Integer, Emp> hm = new HashMap<>();
        try (BufferedReader br = new
                BufferedReader(new FileReader("C:/clone/cc.csv"))) {
            System.out.println(br.readLine());
            br.lines().forEach(l -> {
                String[] split = l.split(",");
                Integer id = Integer.valueOf(split[1]);
                hm.put(id, new Emp(id, split[0]));
            });
//            br.lines().filter(l -> {
//                String[] split = l.split(",");
//                Integer id = Integer.valueOf(split[1]);
//                hm.put(id, new Emp(id, split[0]));
//                return true;
//            });
            System.out.println(hm.size());

            System.out.println(hm.putIfAbsent(2, new Emp(2, "dd")));

            Stream<Emp> stream = hm.values().stream();
            List<Emp> collect = stream.filter(e -> e.getId() > 100).collect(Collectors.toList());
            List<Emp> objects = new ArrayList<>();
            System.out.println(" cccc " + collect.size());
            System.out.println(" www " + hm.size());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class Emp {


    private int id;
    private String n;

    public Emp(int id, String n) {
        this.id = id;
        this.n = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", n='" + n + '\'' +
                '}';
    }
}