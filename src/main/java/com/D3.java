package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D3 {
    static Set c = new HashSet();

    public static void main(String[] args) {

        int i=200;
        double d=i;
        System.out.println(Long.MAX_VALUE);

        //double v = 9.0;
        Object v = 9.0;
        //int b = (int)(double) v;
       // System.out.println(Double.valueOf(String.valueOf(v)).intValue());

    }

    public static void main1s(String[] args) {
        String v = getV();
        ObjectMapper b = new ObjectMapper();
    }

    private static String getV() {
        return "{\"asnId\":\"asnId\",\"receiptLocationId\":\"376\",\"shippedFromLocationId\":\"983\",\"containers\":[{\"containerId\":\"loose\",\"orders\":[{\"orderId\":\"G1gaYEmqpDm27klwA9\",\"orderType\":\"STOCK\",\"items\":[{\"itemId\":\"109690754\",\"packId\":\"109690754\",\"receiptedQuantity\":0,\"receiptedQuantityType\":\"Cases\"}]}]}]}";
    }

    public static void main22(String[] args) {
//        String s1="2019-05-14T05:00:00.000Z";

//        String s2="2019-05-14T22:59";

        Map<String, String> map = new HashMap<>();
        map.get(null);
        System.out.println("vvv " + map.get(null));

    }

    public static void main3(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(2).withHour(22).withMinute(59).withSecond(0).withNano(0);
        System.out.println(localDateTime);
        System.out.println(Timestamp.valueOf(localDateTime));
    }

    public static void main2(String[] args) throws IllegalAccessException, InstantiationException {
        v(String.class);
//        System.out.println(Double.valueOf("1.0"));
//        System.out.println("new ".getClass().toString());
//        System.out.println(String.class.toString());
//        System.out.println(String.class.getClass().equals("c".getClass()));
//        System.out.println(String.class.getClass());
//        String v = String.class.newInstance();
//        Object g = String.class;
        //System.out.println("g""g" instanceof String);

    }

    public static void v(Class s) {
        String.class.getSimpleName();
        System.out.println(String.class.isAssignableFrom(s.getClass()));
        System.out.println(s.getClass().isAssignableFrom(String.class));
    }

    public static void main1(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() + ": in d ");
                synchronized (c) {
                    try {
                        System.out.println("c : " + c);
                        c.add("ssss");
                        System.out.println(Thread.currentThread().getName() + ": in on st  sy block ");
                        c.wait(5000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " in sy block ");
                }
                System.out.println(Thread.currentThread().getName() + " in sy block ");
            }
        };
        new Thread(r).start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("xss : " + c);

        c.add("Stringgg");
        c.add("Stringgg1");
        c.add("Stringgg2");
        c.add("Stringgg3");
        System.out.println("xss xxx: " + c);
//        for (int a = 0; a < 10; a++) {
//            System.out.println("a " + a);
//            new D3().d();
//            System.out.println("=a " + a);
//        }

    }

    private void d() {

        System.out.println(Thread.currentThread().getName() + ": in d ");
        synchronized (c) {
            try {
                System.out.println(Thread.currentThread().getName() + ": in on st  sy block ");
                Thread.sleep(5000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " in sy block ");
        }
        System.out.println(Thread.currentThread().getName() + " in sy block ");
    }
}
