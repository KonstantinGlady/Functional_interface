package com.company.project7;

public class HardwareTicket extends Ticket {

    private String device;
    private String model;
    private String serialNumber;

    public HardwareTicket(String customerName, int id, String description,
                          int due, String device, String model, String serialNumber) {
        super(customerName, id, description, due);
        this.device = device;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\ndevice: " + device + "\nmodel " + model + "\nserial " + serialNumber;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
