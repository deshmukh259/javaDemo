package com.lambda;

public class EvalautateDe {

    public static void main(String[] args) {
        Evalute<Integer> tt = i -> i<0;

        System.out.println("tt = " + tt.isNegative(-44));
    }

}
interface Evalute<T>{
    boolean isNegative(T t);
}
