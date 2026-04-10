package com.hackerrank;

public class Generic {
}

class Printer<T>
{
    public void printArray(T[] t){
        for (T a: t){
            System.out.println(a);
        }

    }

}

