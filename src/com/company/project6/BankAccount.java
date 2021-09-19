package com.company.project6;

public class BankAccount {

    private String name;
    private int id;
    private Double balance;

    public BankAccount(String name, int id, Double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((BankAccount) obj).id;
    }

    @Override
    public String toString() {
        return "name : " + name + " id " + id + " balance " + balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
