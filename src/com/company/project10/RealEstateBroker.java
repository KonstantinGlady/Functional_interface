package com.company.project10;

import java.util.*;
import java.util.function.Supplier;

public class RealEstateBroker {

    public static void main(String[] args) {

        List<Home> homes = Arrays.asList(
                new Home("Forest Acres", 349000.0, 3, 1.7, 5.1, 4.5),
                new Home("Happy Garden", 420000.0, 4, 1.8, 5.0, 4.1),
                new Home("Comfy Condos", 654000.0, 3, 2.5, 7.2, 6.2),
                new Home("Forest Acres", 425000.0, 4, 1.7, 5.1, 4.5),
                new Home("Happy Gardens", 510000.0, 4, 2.3, 5.1, 4.5),
                new Home("Comfy Condos", 190000.0, 2, 0.9, 2.1, 4.5),
                new Home("Comfy Condos", 190000.0, 2, 0.9, 0.7, 4.5),
                new Home("Happy Gardens", 470000.0, 4, 2.1, 5.1, 4.5),
                new Home("Forest Acres", 345000.0, 3, 1.5, 3.2, 5.9),
                new Home("Happy Gardens", 375000.0, 3, 1.5, 2.3, 2.4),
                new Home("Comfy Condos", 190000.0, 2, 0.3, 0.5, 2.4)
        );

        Comparator<Home> byPrice = Comparator.comparing(x -> x.price);
        Comparator<Home> byBedrooms = Comparator.comparing(x -> x.numBedrooms);
        Comparator<Home> byBedroomsRev = byBedrooms.reversed();
        Comparator<Home> byProperties = Comparator.comparing(x -> x.acres,
                (x, y) -> (int) (Math.ceil(y) - Math.ceil(x)));
        Comparator<Home> bySchool = Comparator.comparing(x -> x.schoolDistance,
                (x, y) -> (int) (Math.ceil(x) - Math.ceil(y)));
        Comparator<Home> byTrain = Comparator.comparing(x -> x.trainDistance,
                (x, y) -> (int) (Math.ceil(x) - Math.ceil(y)));

        Supplier<Integer> numPriority = () -> {
            Scanner in = new Scanner(System.in);
            int prio = -1;
            while (prio < 0 || prio > 4) {
                System.out.println("Select a priority: ");
                System.out.println(" 0 - price ");
                System.out.println(" 1 - number of bedrooms ");
                System.out.println(" 2 - size of property");
                System.out.println(" 3 - distance to school");
                System.out.println(" 4 - distance to train station");
                prio = Integer.parseInt(in.nextLine());
                if (prio < 0 || prio > 3) {
                    System.out.println("Invalid priority");
                }
            }
            return prio;
        };

        Supplier<String> comm = () -> {
            Scanner in = new Scanner(System.in);
            String[] communities = {"Forest Acres", "Happy Garden", "Comfy Condos", "any"};
            int selection = -1;
            while (selection < 0 || selection > 3) {
                System.out.println("Select community:");
                System.out.println("0 - Forest Acres");
                System.out.println("1 - Happy Garden");
                System.out.println("2 - Comfy Condos");
                System.out.println("3 - any");
                selection = Integer.parseInt(in.nextLine());
                if (selection < 0 || selection > 3) {
                    System.out.println("invalid selection");
                }
            }
            return communities[selection];
        };

        Supplier<Comparator<Home>> priority = () -> {
            Comparator<Home> ch;
            int numPr = numPriority.get();
            switch (numPr) {
                case 0:
                    ch = byPrice;
                    break;
                case 1:
                    ch = byBedroomsRev;
                    break;
                case 2:
                    ch = byProperties;
                    break;
                case 3:
                    ch = bySchool;
                    break;
                default:
                    ch = byTrain;
            }
            return ch;
        };

        Comparator<Home> priority1, priority2, priority3;
        String community = comm.get();

        List<Home> homesTemp = new ArrayList<>(homes);

        priority1 = priority.get();
        priority2 = priority.get();
        priority3 = priority.get();

        if (!community.equals("any")) {
            homesTemp.removeIf(x -> x.community.equals(community));
        }

        homesTemp.sort(priority1
                .thenComparing(priority2)
                .thenComparing(priority3));

        homesTemp.forEach(x -> System.out.println(x));
    }
}
