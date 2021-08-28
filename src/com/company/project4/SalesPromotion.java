package com.company.project4;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class SalesPromotion {

    public static Customer[] customers = {
            new Customer("Ivan Fedorov", "892323234", "football", "spartak", 3.75, null, 1, "Andrey"),
            new Customer("Larisa Musina", "23423422", "tennis", null, 3.92, "Java", 0, null),
            new Customer("John Smith", "3452345", "football", "Eagles", 3.71, null, 1, "Maria Regina,34523462")
    };

    public static void matcherCustomer(Customer c, ArrayList<BiFunction<Customer, Integer, ? extends Record>> f) {

        for (int i = 0; i < f.size(); i++) {
            Record record;
            int j = 0;

            do {
                record = f.get(i).apply(c, j);
                if (record != null) {
                    System.out.println(record);
                    j = record.index + 1;
                }
            } while (record != null);
        }

    }

    public static void main(String[] args) {

        BiFunction<Customer, Integer, SportRecord> fSport = (x, z) -> {
            SportRecord record = null;
            for (int i = z; i < customers.length && record == null; i++) {
                if (customers[i].sport.equals(x.sport)) {
                    record = new SportRecord(customers[i].name, customers[i].phone, i, customers[i].team);
                    return record;
                }
            }
            return record;
        };

        BiFunction<Customer, Integer, GpaRecord> fGpa = (x, z) -> {
            GpaRecord record = null;
            for (int i = z; i < customers.length && record == null; i++) {
                if (customers[i].gpa >= x.gpa) {
                    record = new GpaRecord(customers[i].name, customers[i].phone, i, customers[i].subject);
                }
            }
            return record;
        };

        ArrayList<BiFunction<Customer, Integer, ? extends Record>> list = new ArrayList<>();
        list.add(fSport);
        list.add(fGpa);

        System.out.println("Sunday football promotion. Call the following customers : ");
        matcherCustomer(
                new Customer(null, null, "football",
                        null, Double.MAX_VALUE, null, Integer.MAX_VALUE, null), list);

        System.out.println(" ");
        System.out.println("Thursday high-tech promotions. Call the following customers: ");
        matcherCustomer(new Customer(null, null, null, null, 3.85, null, Integer.MAX_VALUE, null), list);
    }
}
