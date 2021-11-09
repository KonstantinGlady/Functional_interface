package com.company.project12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Inventory {

    static String partName = null;
    static int quantity = 0;
    static double price = 0.0;
    static int timeLimit = 0;

    public static void main(String[] args) {
        List<Part> parts = Arrays.asList(
                new Part("tires", "Goodyear", 2,
                        new Item("RX2041", 4, 75.25),
                        new Item("SX3355", 2, 90.50)),
                new Part("brakes", "EBC", 1,
                        new Item("EX8426", 2, 125.35)),
                new Part("tires", "Firestone", 1,
                        new Item("FS2112", 3, 60.47),
                        new Item("FS2479", 5, 85.20)),
                new Part("brakes", "Acme", 3,
                        new Item("AC25", 1, 90.74),
                        new Item("AC26", 4, 130.22))
        );

        Supplier<Integer> selectOperation = () -> {
            Scanner in = new Scanner(System.in);
            int operation = -1;
            while (operation < 0 || operation > 5) {
                System.out.println("Select operation: ");
                System.out.println("0 - list inventory");
                System.out.println("1 - find item by quantity and price");
                System.out.println("2 - list items by price");
                System.out.println("3 - count items by part name");
                System.out.println("4 - find items by installation time");
                System.out.println("5 - end program");
                operation = Integer.parseInt(in.nextLine());
                if (operation < 0 || operation > 5) {
                    System.out.println("invalid operation");
                }
            }
            return operation;
        };
        Supplier<String> selectPartName = () ->
                (new Scanner(System.in)).nextLine();
        Supplier<Integer> selectQuantity = () ->
                Integer.parseInt((new Scanner(System.in)).nextLine());
        Supplier<Double> selectPrice = () ->
                Double.parseDouble(new Scanner(System.in).nextLine());
        Supplier<Integer> selectTimeLimit = () ->
                Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println("Welcome to Devos`s shop: ");
        boolean done = false;
        while (!done) {
            switch (selectOperation.get()) {
                case 0:
                    parts.stream()
                            .collect(Collectors.groupingBy(x -> x.name))
                            .forEach((x, y) -> System.out.println(x + " " + y));
                    break;

                case 1:
                    System.out.println("Select part name:");
                    partName = selectPartName.get();
                    System.out.println("Select minimum quantity: ");
                    quantity = selectQuantity.get();
                    System.out.println("Select a price limit: ");
                    price = selectPrice.get();

                    parts.stream()
                            .filter(x -> x.name.equals(partName))
                            .peek(x -> System.out.println(x.name + " by " + x.manu + ":"))
                            .flatMap(x -> x.models.stream())
                            .filter(x -> x.quantity >= quantity)
                            .filter(x -> x.price <= price)
                            .forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("Select part name");
                    partName = selectPartName.get();

                    parts.stream()
                            .filter(x -> x.name.equals(partName))
                            .flatMap(x -> x.models.stream())
                            .sorted(Comparator.comparing(x -> x.price))
                            .forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Select par name:");
                    partName = selectPartName.get();
                    Integer n = parts.stream()
                            .filter(x -> x.name.equals(partName))
                            .flatMap(x -> x.models.stream())
                            .reduce(0,
                                    (x, z) -> x + z.quantity,
                                    (x, y) -> x += y);
                    System.out.println(n);
                    break;

                case 4:
                    System.out.println("Select part name: ");
                    partName = selectPartName.get();
                    System.out.println("Select limit time fo installation: ");
                    timeLimit = selectTimeLimit.get();
                    parts.stream()
                            .filter(x -> x.name.equals(partName))
                            .filter(x -> x.hoursToInstall < timeLimit)
                            .forEach(System.out::println);
                    break;

                default:
                    System.out.println("Bye bye!");
                    done = true;

            }
        }
    }
}
