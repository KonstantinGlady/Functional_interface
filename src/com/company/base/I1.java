package com.company.base;

import java.util.Random;

public interface I1 {
    String s = "I1";

    static void method1() {
        System.out.println(s);
    }

    private int getNumber() {
        return (new Random()).nextInt(100);
    }

    default String method2(String x) {
        return s + x + getNumber();
    }
}
