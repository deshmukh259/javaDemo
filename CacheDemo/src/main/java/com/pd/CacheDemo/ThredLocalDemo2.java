package com.pd.CacheDemo;

public class ThredLocalDemo2 {


    private final static StringBuffer stribBuff = new StringBuffer();
    private static final ThreadLocal<StringBuffer> local = ThreadLocal.withInitial(()->stribBuff);

    public static void main(String[] args) {


        Runnable r =()->{

            StringBuffer stringBuffer = local.get();

            stringBuffer.append("Name:"+Thread.currentThread().getName());

            System.out.println("stringBuffer.toString() = " + stringBuffer.toString());


            System.out.println(stringBuffer+" local = " + local.get().toString());


        };


        new Thread(r,"T1").start();
        new Thread(r,"T2").start();

    }
}
