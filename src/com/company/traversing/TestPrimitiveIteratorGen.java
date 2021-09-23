package com.company.traversing;

import java.util.function.IntConsumer;

public class TestPrimitiveIteratorGen {

    public static void main(String[] args) {
        IntIteratorGen intGen = new IntIteratorGen(1,2,3,4,5,3);
        intGen.forEachRemaining((IntConsumer) x-> System.out.println(x));
    }
}
