package com.company.baseAnonymous;

public class CountyReceipt extends Receipt {

    private double countyTax;

    public CountyReceipt(Receipt receipt, double countyTax) {
        super(receipt);
        this.countyTax = countyTax;
    }

    public double getCountyTax() {
        return countyTax;
    }

    public void setCountyTax(double countyTax) {
        this.countyTax = countyTax;
    }
}
