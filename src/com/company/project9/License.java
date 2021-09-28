package com.company.project9;

import java.time.LocalDate;
import java.util.ArrayList;

public class License {

    private LocalDate expDate;
    private String insurance;
    private STATUS status;
    private ArrayList<Vehicle> vehicles;

    public License(LocalDate expDate, String insurance, Vehicle... v) {
        this.expDate = expDate;
        this.insurance = insurance;
        this.status = STATUS.ACTIVE;
        this.vehicles = new ArrayList<>();
        for (Vehicle a : v) {
            vehicles.add(a);
        }
    }

    public License(LocalDate expDate, String insurance, STATUS status, ArrayList<Vehicle> vehicles) {
        this.expDate = expDate;
        this.insurance = insurance;
        this.status = status;
        this.vehicles = new ArrayList<>(vehicles);
    }

    public License(License l) {
        this.expDate = l.getExpDate();
        this.status = l.getStatus();
        this.vehicles = l.getVehicles();
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "expDate: " + expDate + " insurance " + insurance + " status " + status + " vehicles " + vehicles;
    }
}
