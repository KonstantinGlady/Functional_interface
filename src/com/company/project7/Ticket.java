package com.company.project7;

import java.time.LocalDate;

public abstract class Ticket implements Comparable<Ticket> {

    private String customerName;
    private int id;
    private String description;
    private LocalDate dueDate;
    private LocalDate servicedDate;

    public Ticket(String customerName, int id, String description, int due) {
        this.customerName = customerName;
        this.id = id;
        this.description = description;
        this.dueDate = LocalDate.now().plusDays(due);
        this.servicedDate = LocalDate.now().minusDays(1);
    }

    @Override
    public String toString() {
        return "name: " + customerName + "\nid " + id + "\ndescription " + description + "\ndue " + dueDate
                + "\nserviced " + servicedDate;
    }

    @Override
    public int compareTo(Ticket o) {
        return dueDate.compareTo(o.dueDate);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getServicedDate() {
        return servicedDate;
    }

    public void setServicedDate(LocalDate servicedDate) {
        this.servicedDate = servicedDate;
    }
}
