package com.company.project7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class TicketingSystem {

    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static LocalDate today = LocalDate.now();

    private static void populateDate() {
        tickets.add(new HardwareTicket("Kalpana Patel", 54641,
                "Cell phone won't power on",
                5, "Smartie", "SM250",
                "SN546497-S23"));
        tickets.add(new SoftwareTicket("Chester Rodriguez", 89034,
                "MapApp can't find grandma's house",
                2, "MapApp", "1.01",
                Domain.PHONE_HOSTED));
        tickets.add(new SoftwareTicket("Britney Delmonica", 91472,
                "Can't change banking info on website",
                1, "awesomecheapcellphones.com",
                "2.65", Domain.WEB_HOSTED));
        tickets.add(new HardwareTicket("Kalpana Patel", 54641,
                "Cell phone's screen goes black",
                7, "Rover", "RV100",
                "SN456742-R31"));
    }

    public static void main(String[] args) {
        Supplier<? extends Ticket> nextTicket = () -> {
            Ticket next = null;
            for (int i = 0; i < tickets.size(); i++) {
                Ticket t = tickets.get(i);
                if (t.getServicedDate().compareTo(today) < 0) {
                    if (next == null || t.compareTo(next) < 0) {
                        next = t;
                    }
                }
            }
            if (next != null) {
                next.setServicedDate(today);
            }
            return next;
        };

        BooleanSupplier canClose = () -> {
            boolean result = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nCan you close the next 'Y' or 'N': ");
            if (scanner.nextLine().charAt(0) == 'Y') {
                result = true;
            }
            return result;
        };

        BooleanSupplier isQuittingTime = () -> {
            boolean result = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Is it quitting time? 'Y' or 'N': ");
            if (scanner.nextLine().charAt(0) == 'Y') {
                result = true;
            }
            return result;
        };

        populateDate();
        boolean done = false;
        Ticket next;

        do {
            next = nextTicket.get();
            if (next != null) {
                System.out.println("\n" + next);
                if (canClose.getAsBoolean()) {
                    tickets.remove(next);
                }
                if (isQuittingTime.getAsBoolean()) {
                    done = true;
                }
            }
        } while (next != null && !done);
        if (next == null) {
            System.out.println("\nCongratulations you get 50% bonus today");
        } else {
            System.out.println("\nSee you tomorrow!");
        }
    }

}
