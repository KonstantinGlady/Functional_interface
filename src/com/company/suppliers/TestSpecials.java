package com.company.suppliers;

import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

public class TestSpecials {
    public static void main(String[] args) {

        Random random = new Random();
        BooleanSupplier genBoolean = () -> random.nextInt(2) == 1;
        IntSupplier genInt = () -> random.nextInt();
        LongSupplier genLong = () -> random.nextLong();
        DoubleSupplier genDouble = () -> random.nextDouble();

        System.out.println(genBoolean.getAsBoolean());
        System.out.println(genInt.getAsInt());
        System.out.println(genLong.getAsLong());
        System.out.println(genDouble.getAsDouble());

    }
}
