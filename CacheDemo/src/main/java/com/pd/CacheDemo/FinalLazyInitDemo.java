package com.pd.CacheDemo;

import java.util.List;

public class FinalLazyInitDemo {


    public static void main(String[] args) {

        Lazzy lz= new Lazzy(0,List.of(34,44));

        System.out.println("lz.getX() = " + lz.getX());

    }
}
class Lazzy{

    int x=-1,y=-1;
    final List<Integer> li;


    public Lazzy(int index, final List<Integer> li) {

        this.li = li.subList(index,index+1);
    }

    public int getX() {
        System.out.println("x = " + x);
        return x==-1? x=li.get(0):x;
    }

    public int getY() {
        return y==-1?y=li.get(1):y;
    }
}
