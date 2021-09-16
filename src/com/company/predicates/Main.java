package com.company.predicates;

import java.util.function.Predicate;

public class Main {
    static void result(Predicate<Integer> predicate, Integer arg) {
        if (predicate.test(arg)) {
            System.out.println("result is true " + arg);
        } else {
            System.out.println("result if false " + arg);
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> n = x -> x == 5;
        result(n, 5);
        result(y -> y % 2 == 0 , 5);
    }
}
