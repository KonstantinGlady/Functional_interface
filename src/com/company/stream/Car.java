package com.company.stream;

public class Car {
    String model;
    String manu;
    int mpg;

    public Car(String model, String manu, int mpg) {
        this.model = model;
        this.manu = manu;
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "model= " + model + " manu= " + manu + " mpg=" + mpg + " ";
    }
}
