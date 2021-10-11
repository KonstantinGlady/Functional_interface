package com.company.comparators;

import java.util.Arrays;
import java.util.List;

public class ListWrapper {

    List<Integer> list;

    public ListWrapper(Integer... i) {
        this.list = Arrays.asList(i);
    }
}
