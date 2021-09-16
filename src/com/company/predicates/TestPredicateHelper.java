package com.company.predicates;

import java.util.function.*;

public class TestPredicateHelper {
    public static void main(String[] args) {

        Predicate<Integer> n = x -> x > 5;
        Predicate<String> b = x -> x.charAt(0) == 'H';
        PredicateHelper.result(n, 7);
        PredicateHelper.result(b, "Hello");


        Predicate<Integer> p1 = x -> x > 5;
        System.out.println(p1.or(x -> x < 2).test(9));

        Predicate<Integer> p2 = x -> x > 7;
        System.out.println(p2.and(x -> x % 2 == 1).test(9));

        Predicate<Integer> p3 = x -> x > 7;
        System.out.println(p3.negate().test(9));

        Predicate<Integer> p4 = Predicate.isEqual(3);
        System.out.println(p4.test(3));

        //from java 11
        Predicate<Integer> p5 = x -> x > 7;
        System.out.println(p5.and(Predicate.not(x -> x % 2 == 1)).test(8));

        //if checking null NullPointerException
        Predicate<String> lengthBigger = x -> x.length() > 4;
        Predicate<String> simbolA = x -> x.charAt(0) == 'A';
        System.out.println(lengthBigger.and(simbolA).test("Aloha"));
        //   System.out.println(lengthBigger.and(simbolA).test(null)); //NPE here
        //we do override avoid this
        Predicate<String> nullSafeLength = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 4;
            }

            @Override
            public Predicate<String> and(Predicate<? super String> other) {
                return s -> s == null ? false : test(s) && other.test(s);
            }
        };
        System.out.println(nullSafeLength.and(simbolA).test("Aloha"));
        System.out.println(nullSafeLength.and(simbolA).test(null));

        IntPredicate i = x -> x > 3;
        LongPredicate l = x -> x % 2 == 1;
        DoublePredicate d = x -> x > 8.0;
        System.out.println(i.test(4));
        System.out.println(l.test(5));
        System.out.println(d.test(11.00));

        BiPredicate<String, Integer> biPredicate = (x, y) -> x.equals("Manager") && y > 110000;
        System.out.println(biPredicate.test("Manager", 150000));
    }
}
