package com;

public class ImutableString {

    //int < long < float <duble

    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a,int b){

        return a-b;

    }
    public int mul(int a, int b){
        return a*b;
    }
    public float div(int a,int b){
        return (float)a/(float)b;
    }

    public static void main(String[] args) {
       ImutableString i= new ImutableString();
       int res =i.add(44,22);
        System.out.println("add 44+22 ="+res);

         res =i.sub(44,22);
        System.out.println("sub 44+22 ="+res);

         res =i.mul(44,22);
        System.out.println("mul 44+22 ="+res);

         float re =i.div(43,22);
        System.out.println("div 43+22 ="+re);

    }
}
