package com.company.predicates;

import java.util.function.Predicate;

public class PredicateHelper {
    static <X> void result(Predicate<X> predicate, X arg) {
        if (predicate.test(arg)) {
            System.out.println("result true: " + arg);
        } else {
            System.out.println("result false: " + arg);
        }
    }
}
