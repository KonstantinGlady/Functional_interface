package com.company.functions;

import java.util.function.Function;

public class Transformer {

    public static <T, R> R transform(T t, Function<T, R> function) {
        return function.apply(t);
    }

    public static void main(String[] args) {
        Function<String, Integer> fsi = x -> Integer.parseInt(x);
        Function<Integer, String> fis = x -> Integer.toString(x);
        System.out.println(transform("100", fsi));
        System.out.println(transform(100, fis));
    }
}
