package com.company.suppliers;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {

        Supplier<Integer> generateInteger = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        Supplier<String> generateString = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter string: ");
            return scanner.nextLine();
        };

        System.out.println(generateInteger.get());
        System.out.println(generateString.get());


        Supplier<Integer> selectOperation = () -> {
            int operation = 0;
            Scanner scanner = new Scanner(System.in);

            while (operation < 1 || operation > 4) {
                System.out.println("Select an operation:");
                System.out.println("operation 1: 1");
                System.out.println("operation 2: 2");
                System.out.println("operation 3: 3");
                System.out.println("quit: 4");
                operation = Integer.parseInt(scanner.nextLine());
                if (operation < 1 || operation > 4) {
                    System.out.println("Invalid operation");
                }
            }
            return operation;
        };

        boolean done = false;
        while (!done) {
            switch (selectOperation.get()) {
                case 1:
                    System.out.println("Performing operation 1");
                    break;
                case 2:
                    System.out.println("Performing operation 2");
                    break;
                case 3:
                    System.out.println("Performing operation 3");
                default:
                    done = true;
            }
        }
    }
}
