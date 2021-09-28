package com.company.Collections;

public class MyClass {
    int i1;
    int i2;
    String s;

    public MyClass(int i1, int i2, String s) {
        this.i1 = i1;
        this.i2 = i2;
        this.s = s;
    }

    @Override
    public String toString() {
        return i1 + " " + i2 + " " + s;
    }
}
