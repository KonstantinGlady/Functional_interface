package com.company.collections;

import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Super");
        list.add("Random");
        list.add("Silly");
        list.add("String");

        list.removeIf(x -> x.charAt(0) == 'S');
        list.forEach(x -> System.out.println(x));

        IntUnaryOperator iuo = x -> x;
        int[] iaar = new int[5];
        Arrays.setAll(iaar, iuo);
        for (int i : iaar) {
            System.out.println(i);
        }

        IntToLongFunction ilf = x -> 5;
        long[] larr = new long[4];
        Arrays.setAll(larr, ilf);
        for (long l : larr) {
            System.out.println(l);
        }

        IntToDoubleFunction idf = x -> (new Random().nextFloat());
        double[] darr = new double[4];
        Arrays.setAll(darr, idf);
        for (double d : darr) {
            System.out.println(d);
        }

        IntFunction<String> ifs = x -> {
            String s = "";
            for (int i = 0; i <= x; i++) {
                s += "S";
            }
            return s;
        };

        String[] sarr = new String[4];
        Arrays.setAll(sarr, ifs);

        for (String s : sarr) {
            System.out.println(s);
        }

        List<Integer> iarr = Arrays.asList(16, 12, 8, 4);
        UnaryOperator<Integer> uo = x -> x / 4;
        iarr.replaceAll(uo);
        iarr.forEach(x -> System.out.println(x));

        Map<String, String> map = new TreeMap<>();
        map.put("Smith", "Robert");
        map.put("Jones", "Alex");
        BiFunction<String, String, String> bi = (x, y) -> "Mr. " + y;
        map.replaceAll(bi);
        map.forEach((x, y) -> System.out.println(y + " " + x));

        int[] ibarr = {2, 3, 4, 3};
        IntBinaryOperator ibo = (x, y) -> x * y;
        Arrays.parallelPrefix(ibarr, ibo);
        for (int i : ibarr) {
            System.out.println(i);
        }

        BiFunction<String, Integer, Integer> bfi = (k, v) -> v == null ? null : v / 4;
        Map<String, Integer> map1 = new TreeMap<>();
        map1.put("RED", 32);
        map1.put("GREEN", null);

        System.out.println(map1.compute("RED", bfi));
        System.out.println(map1.compute("GREEN", bfi));
        System.out.println(map1.compute("YELLOW", bfi));
        System.out.println();
        map1.forEach((x, y) -> System.out.println(x + " " + y));

        System.out.println();
        Map<String, MyClass> mapMerge = new TreeMap<>();
        mapMerge.put("k1", new MyClass(1, 2, "Dog"));

        BiFunction<MyClass, MyClass, MyClass> changeI2 = (ov, mv) -> new MyClass(ov.i1, mv.i2, ov.s);
        BiFunction<MyClass, MyClass, MyClass> changeS = (ov, mv) -> new MyClass(ov.i1, ov.i2, mv.s);

        System.out.println(mapMerge.merge("k1", new MyClass(0, 5, null), changeI2));
        System.out.println(mapMerge.merge("k1", new MyClass(0, 0, "Cat"), changeS));
        System.out.println(mapMerge.merge("k2", new MyClass(6, 7, "Bird"), changeS));

        mapMerge.forEach((x, y) -> System.out.println(x + " " + y));

        Set<String> set = new TreeSet<>();
        set.add("Jeremy");
        set.add("Rose");
        set.add("Javier");
        set.removeIf(x -> x.charAt(0) == 'J');
        set.forEach(x -> System.out.println(x));
    }
}
