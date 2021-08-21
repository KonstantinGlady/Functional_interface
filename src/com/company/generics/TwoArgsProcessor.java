package com.company.generics;

@FunctionalInterface
public interface TwoArgsProcessor<X> {
    X process(X arg1, X arg2);
}
