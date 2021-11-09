package com.company.project12;

public class Item {
    String model;
    int quantity;
    double price;

    public Item(String model, int quantity, double price) {
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "model= " + model + " quantity=" + quantity + " price=" + price;
    }
}
