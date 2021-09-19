package com.company.project6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BankTransactions {

    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static int numAccounts;
    private static double prevBalance;
    private static Scanner scanner = new Scanner(System.in);

    public static String promptTransaction() {
        System.out.println("Enter transaction type:");
        System.out.println("OPENACCOUNT");
        System.out.println("DEPOSIT");
        System.out.println("WITHDRAWAL");
        System.out.println("CLOSEACCOUNT");
        System.out.println("QUIT");
        return scanner.nextLine();
    }

    public static double promptAmount() {
        System.out.println("Enter amount:");
        return Double.parseDouble(scanner.nextLine());
    }

    public static String promptName() {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    public static int promptId() {
        System.out.println("Enter id:");
        return Integer.parseInt(scanner.nextLine());
    }

    public static BankAccount findAccountById(int id) {
        int index = accounts.indexOf(new BankAccount(null, id, 0.0));
        return (index > -1) ? accounts.get(index) : null;
    }

    public static void main(String[] args) {

        BiConsumer<String, Double> open = (x, y) -> {
            numAccounts = accounts.size();
            Random random = new Random();
            accounts.add(new BankAccount(x, random.nextInt(10000), y));
        };

        BiConsumer<String, Double> openVerification = (x, y) -> {
            if (accounts.size() == (numAccounts + 1) && accounts.get(numAccounts).getName().equals(x)) {
                System.out.println("Account create successfully: " + x + "  " + accounts.get(numAccounts));
            }
        };

        BiConsumer<Integer, Double> deposit = (x, y) -> {
            BankAccount account = findAccountById(x);
            if (account != null) {
                prevBalance = account.getBalance();
                account.setBalance(prevBalance + y);
            }
        };

        BiConsumer<Integer, Double> depositVerification = (x, y) -> {
            BankAccount account = findAccountById(x);
            if (account != null && prevBalance + y == account.getBalance()) {
                System.out.println("deposit successful " + account);
            } else {
                System.out.println(" account not found! ");
            }
        };

        BiConsumer<Integer, Double> withdraw = (x, y) -> {
            BankAccount account = findAccountById(x);
            if (account != null) {
                if (account.getBalance() - y > 0.0) {
                    prevBalance = account.getBalance();
                    account.setBalance(prevBalance - y);
                }
            }
        };

        BiConsumer<Integer, Double> withDrawVerification = (x, y) -> {
            BankAccount account = findAccountById(x);
            if (account != null) {
                if (account.getBalance() + y == prevBalance) {
                    System.out.println("Withdraw $ from account: " + account);
                } else {
                    System.out.println("Account not found!");
                }

            }
        };

        Consumer<Integer> close = x -> {
            BankAccount account = findAccountById(x);
            numAccounts = accounts.size();
            if (account != null) {
                accounts.remove(account);
            }
        };

        Consumer<Integer> closeVerification = x -> {
            if (accounts.size() + 1 == numAccounts) {
                System.out.println("Account delete successfully");
            } else {
                System.out.println("Could not close account " + x);
            }
        };

        boolean done = false;
        while (!done) {
            String operation = promptTransaction();
            switch (operation) {
                case "OPENACCOUNT":
                    open.andThen(openVerification).accept(promptName(), promptAmount());
                    break;
                case "DEPOSIT":
                    deposit.andThen(depositVerification).accept(promptId(), promptAmount());
                    break;
                case "WITHDRAWAL":
                    withdraw.andThen(withDrawVerification).accept(promptId(), promptAmount());
                    break;
                case "CLOSEACCOUNT":
                    close.andThen(closeVerification).accept(promptId());
                    break;
                case "QUIT":
                    done = true;
                    break;
                default:
                    System.out.println("invalid selection");
            }
        }
    }
}
