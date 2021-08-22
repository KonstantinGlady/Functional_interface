package com.company.lamba.base;

public class Main {

    private static int myField = 5;

    public static void main(String[] args) {

        int localField = 7;

        FiVoid lambdaVoid = x -> System.out.println(x);

        lambdaVoid.method1(3 + myField + localField);
    }
}
