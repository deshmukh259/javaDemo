package com.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class collections8 {

    public static void main(String[] args) {
        HashMap<Integer, Emp> hm = new HashMap<>();
        try (BufferedReader br = new
                BufferedReader(new FileReader("src/main/resources/cc.csv"))) {
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

            Collection<Emp> values = hm.values();
            Stream<Emp> stream = values.stream();
            List<Emp> collect = stream.filter(e -> e.getId() > 100).collect(Collectors.toList());
            List<Emp> objects = new ArrayList<>();
            System.out.println(" cccc " + collect.size());
            System.out.println(" www " + hm.size());
            Stream<String> distinct = values.stream().map(e -> e.getN().toUpperCase()).distinct();
            System.out.println(distinct.collect(Collectors.toList()));

            Stream<Emp> empStream = values.stream().map(e -> {
                e.setN(e.getN().toUpperCase());
                return e;
            });
            System.out.println(empStream.collect(Collectors.toList()));
            System.out.println("-----------");
            System.out.println(values);

            Stream<Emp> empStream1 = values.stream().filter(e -> e.getId() % 5 == 0).map(e -> e);
            System.out.println("-----------");
            //System.out.println(empStream1.count()); // stream cant iterate 2 time ,
            // if any operation done second time it cant iterate means ones it done first time then it close himself
            List<Emp> collect1 = empStream1.collect(Collectors.toList());
            System.out.println(collect1);
            System.out.println("------------min/max---------");

            Emp emp = values.stream().filter(e->e.getId()%6==0).max(Comparator.comparing(e -> e.getN().length())).get();
            System.out.println(emp);
            System.out.println("---reduce---");
            Optional<Emp> reduce = values.stream().reduce((emp5, emp1) -> emp5.getN().length() < emp1.getN().length()? emp5:emp1);
            System.out.println(reduce.get());



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