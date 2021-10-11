package com.company.comparators;

import java.util.Comparator;
import java.util.List;

public class ListWrapperTest {

    public static void main(String[] args) {

        Comparator<List<Integer>> byElement0 = (x, y) -> x.get(0).compareTo(y.get(0));
        Comparator<ListWrapper> byList = Comparator.comparing(x -> x.list, byElement0);

        ListWrapper list1 = new ListWrapper(1, 5, 9);
        ListWrapper list2 = new ListWrapper(2, 4, 8);

        System.out.println(byList.compare(list1, list2));
    }
}
