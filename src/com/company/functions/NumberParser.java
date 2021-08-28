package com.company.functions;

import java.util.ArrayList;
import java.util.function.Function;

public class NumberParser {
    static <R extends Number> R parse(String s, Function<String, R> f) {
        return f.apply(s);
    }

    public static void main(String[] args) {
        ArrayList<Function<String, ? extends Number>> list = new ArrayList<>();
        list.add(x -> Byte.parseByte(x));
        list.add(x -> Short.parseShort(x));
        list.add(x -> Integer.parseInt(x));
        list.add(x -> Long.parseLong(x));
        list.add(x -> Float.parseFloat(x));
        list.add(x -> Double.parseDouble(x));

        String[] numbers = {"10", "20", "30", "40", "50", "60"};
        Number[] result = new Number[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = parse(numbers[i], list.get(i));
            System.out.println(result[i]);
        }
    }
}
