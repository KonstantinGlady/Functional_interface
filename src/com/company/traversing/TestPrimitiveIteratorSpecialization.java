package com.company.traversing;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class TestPrimitiveIteratorSpecialization {

    public static void main(String[] args) {
        IntIterator intIterator = new IntIterator(2, 3, 2, 6, 7);
        intIterator.forEachRemaining((IntConsumer) x -> System.out.println(x));

        System.out.println();
        LongIterator longIterator = new LongIterator(4L, 2L, 7L, 1L);
        longIterator.forEachRemaining((LongConsumer) x -> System.out.println(x));

        System.out.println();
        DoubleIterator doubleIterator = new DoubleIterator(3.3, 2.2, 6.6, 1.1);
        doubleIterator.forEachRemaining((DoubleConsumer) x -> System.out.println(x));
    }
}
