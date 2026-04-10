package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class CheckFilesDemo {

    public static void main(String[] args) throws IOException {
        long st = new Date().getTime();
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> m = new HashMap<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\clone\\data.csv"))) {
                String str;
                while ((str = br.readLine()) != null) {
                    String d[] = str.split(",");
                    map.put(d[0], d[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (Stream<Path> paths = Files.walk(Paths.get("C:\\clone\\SMS\\sit-phase-1.5\\supplychain-stockmovement-service"))) {
            paths.forEach(x -> w(x, map, m));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> s = m.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }


        System.out.println("----------- invalid data found ----");
        System.out.println(map);
        System.out.println("time elapsed : " + (new Date().getTime() - st));

    }

    public static void w(Path f, HashMap<String, String> map, HashMap<String, String> m) {

//        if (!f.toString().endsWith(".java"))
//            return;
        try (BufferedReader br = new BufferedReader(new FileReader(f.toFile()))) {
            String str;
            while ((str = br.readLine()) != null) {
                for (Map.Entry<String, String> me : map.entrySet()) {
                    String k = me.getKey();
                    String v = me.getValue();
                    if (str.contains(k) && str.contains(v)) {
                        m.put(k, v);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
