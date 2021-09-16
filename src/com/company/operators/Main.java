package com.company.operators;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        UnaryOperator<String> concat = x -> x + x;
        UnaryOperator<Integer> increment = x -> ++x;
        UnaryOperator<Long> decrement = x -> --x;
        UnaryOperator<String> sident = UnaryOperator.identity();

        System.out.println(sident.apply("My"));
        System.out.println(concat.apply("My"));
        System.out.println(increment.apply(10));
        System.out.println(decrement.apply(10L));

        IntUnaryOperator iuo = x -> x + 5;
        LongUnaryOperator luo = x -> x / 2L;
        DoubleUnaryOperator duo = x -> x * 2.1;

        System.out.println(iuo.applyAsInt(5));
        System.out.println(luo.applyAsLong(6L));
        System.out.println(duo.applyAsDouble(3.2));

        BinaryOperator<String> biConcat = (x, y) -> x + y;
        BinaryOperator<Integer> biMultiply = (x, y) -> x * y;
        BinaryOperator<Long> biSubtract = (x, y) -> x / y;

        System.out.println(biConcat.apply("x", "y"));
        System.out.println(biMultiply.apply(5, 6));
        System.out.println(biSubtract.apply(6L, 2L));

        IntBinaryOperator ibo = (x, y) -> x + y + 5;
        LongBinaryOperator lbo = (x, y) -> x / y - 1;
        DoubleBinaryOperator dbo = (x, y) -> x - y + 3;

        System.out.println(ibo.applyAsInt(4, 5));
        System.out.println(lbo.applyAsLong(8L, 2L));
        System.out.println(dbo.applyAsDouble(6.3, 2.1));

    }
}
