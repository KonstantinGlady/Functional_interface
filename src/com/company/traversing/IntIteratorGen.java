package com.company.traversing;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.function.IntConsumer;

public class IntIteratorGen implements PrimitiveIterator<Integer, IntConsumer> {

    private int[] array;
    private int cursor;

    public IntIteratorGen(int... a) {
        cursor = 0;
        array = Arrays.copyOf(a, a.length);
    }

    @Override
    public void forEachRemaining(IntConsumer action) {
        while (hasNext()) {
            action.accept(array[cursor]);
            cursor++;
        }
    }

    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }

    @Override
    public Integer next() {
        int i = 0;
        if (hasNext()) {
            i = array[cursor];
            cursor++;
        }
        return i;
    }
}
