package com.company.project8;

public class Employee {

    String name;
    double salary;
    double bonus;
    double multiplier;

    public Employee(String name, double salary, double bonus, double multiplier) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return "name " + name + " salary " + salary + " bonus " + bonus;
    }
}
