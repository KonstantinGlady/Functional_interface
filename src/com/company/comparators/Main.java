package com.company.comparators;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class Main {

    public static String removeVowels(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    public static void main(String[] args) {

        Comparator<String> byConsonants = (x, y) -> removeVowels(x).compareTo(removeVowels(y));
        System.out.println(byConsonants.compare("Larry", "Libby"));

        Comparator<Integer> byIntCompareTo = (x, y) -> x.compareTo(y);
        System.out.println(byIntCompareTo.compare(1000, 1002));

        Comparator<Integer> byIntDifference = (x, y) -> x - y;
        System.out.println(byIntDifference.compare(1000, 1002));

        Comparator<String> natural = Comparator.naturalOrder();
        System.out.println(natural.compare("Larry", "Libby"));

        Comparator<String> reversed = Comparator.reverseOrder();
        System.out.println(reversed.compare("Larry", "Libby"));

        System.out.println(Comparator.nullsFirst(byConsonants).compare("Larry", null));
        System.out.println(Comparator.nullsLast(byConsonants).compare("Larry", null));
        System.out.println(byConsonants.reversed().compare("Larry", "Libby"));

        Student s1 = new Student("Larry", 1000, 3.72);
        Student s2 = new Student("Libby", 1001, 3.68);

        Function<Student, Double> gpaKey = x -> x.gpa;
        Comparator<Student> byGpa = Comparator.comparing(gpaKey);
        System.out.println(byGpa.compare(s1, s2));
        //same result
        Comparator<Student> byId = Comparator.comparing(x -> x.gpa);
        System.out.println(byId.compare(s1, s2));

        Comparator<Student> byName = Comparator.comparing(x -> x.name);
        System.out.println(byName.compare(s1, s2));

        Comparator<Student> byNameConsonants = Comparator.comparing(x -> x.name,
                (x, y) -> removeVowels(x).compareTo(removeVowels(y)));
        System.out.println(byNameConsonants.compare(s1, s2));

        Comparator<Student> byGpaCeil = Comparator.comparing(x -> x.gpa,
                (x, y) -> (int) (Math.ceil(x) - Math.ceil(y)));
        System.out.println(byGpaCeil.compare(s1, s2));

        ToDoubleFunction<Student> gpa2 = x -> x.gpa;
        System.out.println(Comparator.comparingDouble(gpa2).compare(s1, s2));

        System.out.println(Comparator.comparingInt((Student s) -> s.id).compare(s1, s2));
    }
}
