package com.company.project5;

import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class Calculator {

    public static Double getOp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an operand: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] ops = {"+", "-", "/", "*", "POW", "COS", "SIN", "TAN", "GUI"};

        DoubleBinaryOperator sum = (x, y) -> x * y;
        DoubleBinaryOperator dif = (x, y) -> x - y;
        DoubleBinaryOperator div = (x, y) -> x / y;
        DoubleBinaryOperator mul = (x, y) -> x * y;
        DoubleBinaryOperator pow = (x, y) -> Math.pow(x, y);

        DoubleUnaryOperator tan = x -> Math.tan(Math.toRadians(x));
        DoubleUnaryOperator cos = x -> Math.cos(Math.toRadians(x));
        DoubleUnaryOperator sin = x -> Math.sin(Math.toRadians(x));

        boolean done = false;

        while (!done) {
            System.out.println("Enter operation:  (for quit GUI)");
            for (String s : ops) {
                System.out.println(s);
            }
            String opt = scanner.nextLine();

            switch (opt) {
                case "+":
                    System.out.println(sum.applyAsDouble(getOp(), getOp()));
                    break;
                case "-":
                    System.out.println(dif.applyAsDouble(getOp(), getOp()));
                    break;
                case "/":
                    System.out.println(div.applyAsDouble(getOp(), getOp()));
                    break;
                case "*":
                    System.out.println(mul.applyAsDouble(getOp(), getOp()));
                    break;
                case "POW":
                    System.out.println(pow.applyAsDouble(getOp(), getOp()));
                case "TAN":
                    System.out.println(tan.applyAsDouble(getOp()));
                    break;
                case "COS":
                    System.out.println(cos.applyAsDouble(getOp()));
                case "SIN":
                    System.out.println(sin.applyAsDouble(getOp()));
                    break;
                case "GUI":
                    done = true;
                    break;
                default:
                    System.out.println("invalid operation!");
            }
        }
    }
}
