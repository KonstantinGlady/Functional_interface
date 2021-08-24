package com.company.project3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class DiscountDave {

    public static boolean qualifyCustomers(Customer c, ArrayList<Predicate<Customer>> pList) {
        int score = 0;
        for (Predicate<Customer> p : pList) {
            if (p.test(c)) {
                score++;
                System.out.println("match " + score);
            }
        }
        return score >= 3;
    }

    public static void main(String[] args) {

        ArrayList<Predicate<Customer>> qualifierFord = new ArrayList<>();
        qualifierFord.add(c -> c.gender.equals("female"));
        qualifierFord.add(c -> c.state.equals("Pennsylvania") || c.state.equals("New Jersey"));
        qualifierFord.add(c -> c.age > 40 && c.age < 60);
        qualifierFord.add(c -> c.ed.compareTo(Education.HighSchool) > 0);

        Customer c1 = new Customer("female", "Pennsylvania", 42, Education.Phd);
        Customer c2 = new Customer("male", "Alaska", 25, Education.Bachelor);

        System.out.println("Customer is good for offer " + qualifyCustomers(c1, qualifierFord));
        System.out.println("Customer is good for offer " + qualifyCustomers(c2, qualifierFord));
    }
}
