package com.company.traversing;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class IntIterator implements PrimitiveIterator.OfInt {

    private int[] array;
    private int cursor;

    public IntIterator(int... a) {
        cursor = 0;
        array = Arrays.copyOf(a, a.length);
    }

    @Override
    public int nextInt() {
        int i = 0;
        if (hasNext()) {
            i = array[cursor];
            cursor++;
        }
        return i;
    }

    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }
}
