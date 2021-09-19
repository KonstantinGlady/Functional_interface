package com.company.consumers;

import java.util.function.*;

public class Main {

    private static int sum = 0;
    private static int con = 1;

    private static int a = 0;
    private static long b = 0;
    private static double c = 1.0;

    private static int biSum = 0;
    private static String components = "";

    public static void main(String[] args) {

        Consumer<Integer> consumer = x -> sum += x;
        consumer.accept(4);
        System.out.println(sum);

        Consumer<Integer> consumer1 = x -> sum += x;
        Consumer<Integer> consumer2 = x -> con *= x;

        consumer1.andThen(consumer2).accept(4);
        consumer1.andThen(consumer2).accept(5);

        System.out.println(sum + " " + con);

        IntConsumer ic = x -> a = x + 3;
        LongConsumer lc = x -> b = x / 2L;
        DoubleConsumer dc = x -> c = x * c;

        ic.andThen(x -> System.out.println(a)).accept(2);
        lc.andThen(x -> System.out.println(b)).accept(6L);
        dc.andThen(x -> System.out.println(c)).accept(4.0);

        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            biSum += x;
            components += y;
        };

        biConsumer.andThen((x, y) -> System.out.println(x + " " + y)).accept(6, " Term 1");
        biConsumer.andThen((x, y) -> System.out.println(x + " " + y + " sum " + biSum + " " + components))
                .accept(7, " Term 2");

        ObjIntConsumer<String> oic = (x, y) -> System.out.println(x + " "+ y);
        oic.accept("value", 5);

    }
}
