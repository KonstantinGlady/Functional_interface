package com.company.traversing;

import java.util.*;

public class TestCars {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Nisan", "Sentra"),
                new Car("Chevrolet", "Vega"),
                new Car("Hyundai", "Elantra")
        );

        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        cars.iterator().forEachRemaining(x -> System.out.println(x));

        System.out.println("\nspliterator whole array");
        Spliterator<Car> carSpliterator = cars.spliterator();
        carSpliterator.forEachRemaining(x -> System.out.println(x));

        System.out.println("\nhalf array");
        carSpliterator = cars.spliterator();
        Spliterator<Car> halfCars = carSpliterator.trySplit();
        halfCars.forEachRemaining(x -> System.out.println("1 part: " + x));
        System.out.println();
        carSpliterator.forEachRemaining(x -> System.out.println("2 part: " + x));

        System.out.println("\nfor each");
        cars.forEach(x-> System.out.println(x));

        System.out.println("TreeMap");

        TreeMap<String, Double> map = new TreeMap<>();
        map.put("Ivan Ivanov", 333.3);
        map.put("Irina Vasina",444.4);
        map.put("Pavel Larin", 3332.2);

        map.forEach((x,y) -> System.out.println(x + " makes " + y));
    }
}
