package com.company.comparators;

public class Student {

    String name;
    int id;
    Double gpa;

    public Student(String name, int id, Double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Name: " + name + " gpa " + gpa;
    }
}
