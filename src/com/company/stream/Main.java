package com.company.stream;

import com.company.comparators.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.*;

import static com.company.comparators.Main.removeVowels;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

        Stream<Integer> tenRandomNumbers = Stream.generate(() -> (new Random().nextInt(100))).limit(10);
        tenRandomNumbers.forEach(System.out::println);

        Stream.of("RED", "GREEN", "BLUE", "RED")
                .filter(x -> x.equals("YELLOW"))
                .forEach(System.out::println);

        Predicate<String> isRed = x -> x.equals("RED");
        Stream.of("RED", "GREEN", "BLUE", "RED")
                .filter(isRed.or(x -> x.indexOf("R") > -1))
                .forEach(System.out::println);

        List<String> list = Arrays.asList("RED", "GREEN");
        list.stream()
                .filter(x -> x.equals("GREEN"))
                .forEach(System.out::println);


        //natural order
        Stream.of("Kyle", "Jaquiline", "Jimmy")
                .sorted()
                .forEach(System.out::println);

        Stream.of("Kyle", "Jaquiline", "Jimmy")
                .sorted((x, y) -> removeVowels(x).compareTo(removeVowels(y)))
                .forEach(System.out::println);

        //min max возвращают Optional
        Stream.of("Kyle", "Jaquiline", "Jimy")                             //Stream<String>
                .min((x, y) -> removeVowels(x).compareTo(removeVowels(y))) //Optional<String>
                .ifPresent(System.out::println);

        //flatMap flattens a stream to a target types
        Stream.of(new Class("Biology",
                                new Student("Jimmy", 1001, 3.81),
                                new Student("Mark", 1003, 4.32)),
                        new Class("Phisics",
                                new Student("Kalpana", 1000, 4.65),
                                new Student("Javier", 1010, 5.00))) //Stream<Class>
                .flatMap(x -> x.students.stream())                                //Stream<Student>
                .forEach(System.out::println);

        // map dont flattens instead make List<Student>
        Stream.of(new Class("Biology",
                                new Student("Jimmy", 1001, 3.81),
                                new Student("Mark", 1003, 4.32)),
                        new Class("Phisics",
                                new Student("Kalpana", 1000, 4.65),
                                new Student("Javier", 1010, 5.00))) //Stream<Student>
                .map(x -> x.students)                                     //Stream<List<Student>>
                .forEach(System.out::println);

        //reduce
        Stream.of(1, 2, 3, 4, 5)
                .reduce((x, y) -> x * y)          //Stream<Integer>
                .ifPresent(System.out::println);  //Optional<Integer>

        // reduce reloaded with identity which gives initial value
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)                      //Stream<Integer>
                        .reduce(1, (x, y) -> x * y) //Integer
        );

        //reduce 3
        Stream<TwoInts> two = Stream.of(
                new TwoInts(1, 2),
                new TwoInts(8, 9));

        BiFunction<Integer, TwoInts, Integer> accumulator = (x, y) -> x + y.i2;
        BinaryOperator<Integer> combiner = (x, y) -> x += y;
        Integer j = two.reduce(0, accumulator, combiner);
        System.out.println(j);

        //mutable reduction
        Supplier<List<Character>> supp = () -> new ArrayList<>();
        BiConsumer<List<Character>, Character> acc = (x, y) -> {
            System.out.print("x = " + x + " y = " + y + " result = ");
            if (Character.isAlphabetic(y)) {
                x.add(0, y);
            } else {
                x.add(y);
            }
            x.forEach(System.out::print);
            System.out.println();
        };
        BinaryOperator<List<Character>> comb1 = (x, y) -> {
            x.addAll(y);
            return x;
        };
        Stream.of('1', 'A', 'B', '2')
                .collect(Collector.of(supp, acc, comb1))
                .forEach(System.out::print);
        System.out.println();

        //with 4
        Supplier<StringBuilder> supps = () -> new StringBuilder();
        BiConsumer<StringBuilder, String> accs = (x, y) -> {
            x.append(y.replaceAll("[aeiou]", ""));
        };
        BinaryOperator<StringBuilder> combs = (x, y) -> {
            x.append(y);
            return x;
        };
        Function<StringBuilder, String> fins = x -> x.toString();

        String s = Stream.of("Joe", "Kalpana", "Christopher")
                .collect(Collector.of(supps, accs, combs, fins));
        System.out.println(s);

        //Collectors
        //in original order
        Stream.of('1', 'a', '2', 'b')
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //collectingAndThen
        BiConsumer<List<Character>, Character> accc2 = (x, y) -> {
            if (Character.isAlphabetic(y)) {
                x.add(0, y);
            } else {
                x.add(y);
            }
        };

        Function<List<Character>, String> fins2 = x -> {
            String t = "";
            for (Character c : x) {
                t += c;
            }
            return t;
        };

        String s1 = Stream.of('1', 'a', 'b', '2')         //Stream<Character>
                .collect(Collectors.collectingAndThen(
                        Collector.of(supp, accc2, comb1), //List<Character>
                        fins2));
        System.out.println(s1);

        //reducing factorial of 5
        Stream.of(1, 2, 3, 4, 5)                         //Stream<Integer>
                .collect(Collectors.reducing((x, y) ->
                        x *= y))                         //Optional<Integer>
                .ifPresent(System.out::println);

        //joining
        String s2 = Stream.of("RED", "GREEN", "BLUE")
                .collect(Collectors.joining(","));
        System.out.println(s2);

        //groupingBy
        Stream.of(new Car("Elantra", "Hyundai", 27),
                        new Car("Skylark", "Buick", 33),
                        new Car("Accent", "Hyundai", 30),
                        new Car("Regal", "Buick", 25))      //Stream<Car>
                .collect(Collectors.groupingBy(x -> x.manu))                 //Map<String, List<Car>>
                .forEach((x, y) -> System.out.println(x + " : " + y));

        //groupingBy and mapping
        Stream.of(new Car("Elantra", "Hyundai", 27),
                        new Car("Skylark", "Buick", 33),
                        new Car("Accent", "Hyundai", 30),
                        new Car("Regal", "Buick", 25))        //Stream<Car>
                .collect(
                        Collectors.groupingBy(x ->                             //Map<String, List<Integer>>
                                        x.manu,
                                Collectors.mapping(x -> x.mpg, Collectors.toList())  //List<Integer>
                        )
                )
                .forEach((x, y) -> System.out.println(x + " " + y));

        //partitioningBy
        Stream.of(new Car("Elantra", "Hyundai", 27),
                        new Car("Skylark", "Buick", 33),
                        new Car("Accent", "Hyundai", 30),
                        new Car("Regal", "Buick", 25))        //Stream<Car>
                .collect(
                        Collectors.partitioningBy(x ->
                                x.mpg >= 30)                                   //Map<Boolean, List<Car>>
                )
                .forEach((x, y) -> System.out.println(x + " " + y));

        //Summing
        Integer sum = Stream.of(new Car("Elantra", "Hyundai", 27),
                        new Car("Skylark", "Buick", 33),
                        new Car("Accent", "Hyundai", 30),
                        new Car("Regal", "Buick", 25))        //Stream<Car>
                .collect(Collectors.summingInt(x -> x.mpg));
        System.out.println("sum of mpg " + sum);

        ////Stream.Builder subinterface of Consumer
        Stream.Builder<String> bld = Stream.builder();
        bld.accept("RED");
        bld.accept("GREEN");
        bld.accept("BLUE");

        Stream<String> st = bld.build(); // after build you cant accept anymore parameters
        try {
            bld.accept("YELLOW");
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException");
        }
        st.forEach(System.out::println);

        //
        Stream.builder()
                .add("RED")
                .add("GREEN")
                .add("BLUE")
                .build()
                .forEach(System.out::println);

        //peek method useful for reporting and debugging .Its accepts same type element
        Stream.of(1, 2, 3, 4)
                .peek(System.out::println)
                .reduce((x, y) -> x += y)
                .ifPresent(System.out::println);

        //IntStream, LongStream, DoubleStream
        IntStream intStream =
                Stream.of(new Car("Buick", "Regal", 25),
                                new Car("Hyundai", "Elantra", 27),
                                new Car("Buick", "Skylark", 26),
                                new Car("Hyundai", "Accent", 30))  // Stream<Car>
                        .mapToInt(x -> x.mpg);                             //IntStream

        //max
        intStream.max()
                .ifPresent(System.out::println);

        //min
        LongStream.of(1, 2, 3, 4)
                .min()
                .ifPresent(System.out::println);

        //average
        DoubleStream.of(2.2, 3.3, 4.4, 5.5)
                .average()
                .ifPresent(System.out::println);

        //sum
        int sum2 = IntStream.of(1, 3, 4, 5)
                .sum();
        System.out.println(sum2);

    }
}
