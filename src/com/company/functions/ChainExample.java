package com.company.functions;

import java.util.function.*;

public class ChainExample {
    public static void main(String[] args) {
        Function<String, Boolean> fsb = x -> Boolean.parseBoolean(x);
        System.out.println(fsb.andThen(x -> x == true ? 1 : 0).apply("true"));

        Function<Boolean, Integer> fbi = x -> x == true ? 1 : 0;
        System.out.println(fbi.compose(fsb).apply("true"));

        Function<String, String> fss = Function.identity();
        System.out.println(fss.apply("Hello World!"));

        IntFunction<String> fi = x -> Integer.toString(x);
        DoubleFunction<Boolean> fb = x -> x > 5.0 ? true : false;
        LongFunction<Integer> fil = x -> (int) x;
        System.out.println(fi.apply(6));
        System.out.println(fb.apply(6.0));
        System.out.println(fil.apply(20L));

        ToIntFunction<String> ti = x -> Integer.parseInt(x);
        ToLongFunction<Double> fl = x -> x.longValue();
        ToDoubleFunction<Integer> tdi = x -> Integer.valueOf(x).doubleValue();
        System.out.println(ti.applyAsInt("5"));
        System.out.println(fl.applyAsLong(22.2));
        System.out.println(tdi.applyAsDouble(2));

        DoubleToIntFunction dif = x -> new Double(x).intValue();
        IntToLongFunction llf = x -> new Double(x).longValue();
        System.out.println(dif.applyAsInt(5));
        System.out.println(llf.applyAsLong(4));

        BiFunction<Integer, Character, String> bi = (i, c) -> {
            if (Character.isUpperCase(c)) {
                return i % 2 == 0 ? "EVEN" : "ODD";
            }
            return i % 2 == 0 ? "even" : "odd";
        };
        System.out.println(bi.apply(4,'U'));

        ToIntBiFunction<String, Double> tib = (x, y) -> Integer.parseInt(x) + new Double(y).intValue();
        System.out.println(tib.applyAsInt("4", 5.5));
    }

}
