package com.company.base;

public class Main {
    public static void main(String[] args) {
        I1 obj1 = new C1();
        I1 obj2 = new C2();
        I1.method1();
        System.out.println( obj1.method2(" hello"));;
        System.out.println(obj2.method2("hello"));;
    }
}
