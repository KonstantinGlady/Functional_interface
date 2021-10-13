package com.company.optionals;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        String t = null;
        String u = "Hello!";

        String s = Optional.ofNullable(t).orElse(u);
        System.out.println(s);

        String s2 = Optional.ofNullable(t).orElseGet(() -> u);
        System.out.println(s2);

        try {
            String s3 = null;
            String opt = Optional.ofNullable(s3).orElseThrow(() -> new Exception("Null Optional"));
            System.out.println(opt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //same in java 10
        try {
            String s4 = null;
            String opt2 = Optional.ofNullable(s4).orElseThrow();
            System.out.println(opt2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Supplier<Optional<String>> supplier = () -> {
            System.out.println("Enter a string: ");
            return Optional.of((new Scanner(System.in)).nextLine());
        };
        String s5 = null;
        Optional<String> opt3 = Optional.ofNullable(s5).or(supplier);
        if (opt3.isPresent()) {
            System.out.println(opt3.get());
        }

        //same
        String s6 = null;
        Optional.ofNullable(s).or(supplier).ifPresent((x) -> System.out.println(x));

        //the filter method only called on non-null Optionals
        String s7 = null;
        System.out.println(
                Optional.ofNullable(s7).filter(x -> x.length() > 2)
        );

        //the chains stop executing after the first falls predicate
        Optional.of("Hello")
                .filter(x -> x.charAt(0) == 'H')
                .filter(x -> x.length() > 2)
                .filter(x -> x.charAt(1) == 'e')
                .ifPresent(x -> System.out.println(x));

        //can be OR
        Predicate<String> p = x -> x.charAt(0) == 'i';
        Optional.of("Hello or")
                .filter(p.or(x -> x.charAt(0) == 'H'))
                .ifPresent(x -> System.out.println(x));

        Optional.of("4")
                .map(x -> Integer.parseInt(x))
                .filter(x -> x > 2)
                .filter(x -> x % 2 == 0)
                .ifPresent(x -> System.out.println(x));

        //not working math
        Optional<Integer> o1 = Optional.of(2);
        o1.ifPresent(x -> ++x);
        o1.ifPresent(x -> System.out.println(x + " = 2 with Consumer"));
        //working
        Optional.of(2)
                .map(x -> ++x)
                .ifPresent(x -> System.out.println(x + " = 2 with Map"));

        //flatMap works with Optional
        Optional.of("4")
                .flatMap(x -> Optional.of(Integer.parseInt(x)))
                .ifPresent(x -> System.out.println(x));

        Optional.of(new Resource())
                .filter(x -> x.count > 0)
                .map(x -> new Resource())
                .filter(x -> x.count > 0)
                .map(x -> new Resource())
                .filter(x -> x.count > 0)
                .map(x -> new Resource());// last one doesn`t execut
    }
}
