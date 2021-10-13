package com.company.project11;

public class Guess {

    int number;
    int guess;

    public Guess(int number) {
        this.number = number;
    }

    public Guess(int guess, int number) {
        this.guess = guess;
        this.number = number;
    }
}
