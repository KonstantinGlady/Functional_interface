package com.company.base;

public interface I1 {
    String s = "I1";

    static void method1() {
        System.out.println(s);
    }

    default String method2(String x) {
        return s + x;
    }
}
