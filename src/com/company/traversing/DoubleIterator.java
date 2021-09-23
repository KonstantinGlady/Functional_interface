package com.company.traversing;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class DoubleIterator implements PrimitiveIterator.OfDouble {
    private double[] array;
    private int cursor;

    public DoubleIterator(double... a) {
        cursor = 0;
        array = Arrays.copyOf(a, a.length);
    }

    @Override
    public double nextDouble() {
        double d = 0.0;
        if (hasNext()) {
            d = array[cursor];
            cursor++;
        }
        return d;
    }

    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }
}
