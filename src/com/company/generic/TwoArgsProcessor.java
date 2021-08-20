package com.company.generic;

@FunctionalInterface
public interface TwoArgsProcessor<X> {
    X process(X arg1, X arg2);
}
