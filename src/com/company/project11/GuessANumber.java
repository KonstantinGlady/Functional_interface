package com.company.project11;

import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class GuessANumber {

    public static void main(String[] args) {

        UnaryOperator<Guess> guessIt = x -> {
            System.out.println("Guess a number between 0 and 9:");
            return new Guess(new Scanner(System.in).nextInt(), x.number);
        };

        Predicate<Guess> guessIsCorrect = x -> {
            if (x.guess != x.number) {
                return true;
            }
            System.out.println("You guessed correctly! ");
            return false;
        };

        Optional.of(new Guess(new Random().nextInt(10)))
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .map(guessIt)
                .filter(guessIsCorrect)
                .ifPresent(x -> System.out.println("Sorry! Couldn't guess " + x.number));
    }
}
