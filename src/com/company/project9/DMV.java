package com.company.project9;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class DMV {
    public static void main(String[] args) {

        Map<String, License> d = new TreeMap<>();

        Supplier<Integer> selectOperation = () -> {
            int operation = -1;
            Scanner in = new Scanner(System.in);

            while (operation < 0 || operation > 7) {
                System.out.println("Select operation:");
                System.out.println("0 - add driver, 1 - remove driver, 2 - change insurance, 3 - suspend llc," +
                        "4 - renew license, 5 - add veh, 6 - remove veh, 7- quite");
                operation = Integer.parseInt(in.nextLine());
                if (operation < 0 || operation > 7) {
                    System.out.println("Invalid operation!");
                }
            }
            return operation;
        };

        Supplier<String> licenseId = () -> {
            System.out.println("Enter license id: ");
            Scanner in = new Scanner(System.in);
            return in.nextLine();
        };

        Supplier<String> insurance = () -> {
            System.out.println("Enter insurance: ");
            Scanner in = new Scanner(System.in);
            return in.nextLine();
        };

        Supplier<LocalDate> expDate = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter expires date ");
            System.out.println("Year: ");
            int year = Integer.parseInt(in.nextLine());
            System.out.println("Month: ");
            Month month = Month.valueOf(in.nextLine());
            System.out.println("Day: ");
            int day = Integer.parseInt(in.nextLine());
            return LocalDate.of(year, month, day);
        };

        Supplier<Vehicle> vehicle = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter vehicle");
            System.out.println("make: ");
            String make = in.nextLine();
            System.out.println("model: ");
            String model = in.nextLine();
            System.out.println("year: ");
            int year = Integer.parseInt(in.nextLine());
            return new Vehicle(make, model, year);
        };

        int operation = 0;
        while (operation != 7) {

            operation = selectOperation.get();

            switch (operation) {
                case 0:
                    BiFunction<License, License, License> addDriver = (ov, nv) -> ov;
                    System.out.println(d.merge(licenseId.get(), new License(expDate.get(), null), addDriver));
                    break;
                case 1:
                    BiFunction<String, License, License> remove = (k, v) -> null;
                    System.out.println(d.computeIfPresent(licenseId.get(), remove));
                    break;
                case 2:
                    BiFunction<License, License, License> changeInsurance = (ov, nv) ->
                            new License(ov.getExpDate(),
                                    nv.getInsurance(),
                                    ov.getStatus(),
                                    ov.getVehicles());
                    System.out.println(
                            d.merge(licenseId.get(),
                                    new License(null, insurance.get()),
                                    changeInsurance));
                    break;
                case 3:
                    BiFunction<String, License, License> suspend = (k, v) -> new License(v.getExpDate(), v.getInsurance(),
                            STATUS.SUSPENDED, v.getVehicles());
                    System.out.println(
                            d.computeIfPresent(licenseId.get(), suspend));
                    break;
                case 4:
                    BiFunction<License, License, License> renew = (ov, nv) -> new License(expDate.get(), ov.getInsurance(),
                            STATUS.ACTIVE, ov.getVehicles());
                    System.out.println(
                            d.merge(licenseId.get(),
                                    new License(expDate.get(),
                                            null), renew));
                    break;
                case 5:
                    BiFunction<License, License, License> addVehicle = (ov, nv) -> {
                        License tmp = new License(ov);
                        ArrayList<Vehicle> vehicles = tmp.getVehicles();
                        vehicles.add(nv.getVehicles().get(0));
                        tmp.setVehicles(vehicles);
                        return tmp;
                    };
                    System.out.println(
                            d.merge(licenseId.get(),
                                    new License(null, null, vehicle.get()),
                                    addVehicle));
                    break;
                case 6:
                    BiFunction<License, License, License> removeVehicle = (ov, nv) -> {
                        License tmp = new License(ov);
                        ArrayList<Vehicle> vehicles = tmp.getVehicles();
                        Vehicle newVehicle = nv.getVehicles().get(0);
                        vehicles.removeIf(x -> x.getMake().equals(newVehicle.getMake())
                                && x.getModel().equals(newVehicle.getModel())
                                && x.getYear() == newVehicle.getYear());
                        tmp.setVehicles(vehicles);
                        return tmp;
                    };
                    System.out.println(
                            d.merge(licenseId.get(),
                                    new License(null, null, vehicle.get()),
                                    removeVehicle));
            }
        }
    }
}
