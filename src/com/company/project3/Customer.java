package com.company.project3;

public class Customer {
    String gender;
    String state;
    int age;
    Education ed;

    public Customer(String gender, String state, int age, Education ed) {
        this.gender = gender;
        this.state = state;
        this.age = age;
        this.ed = ed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", ed=" + ed +
                '}';
    }
}
