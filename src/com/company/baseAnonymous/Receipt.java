package com.company.baseAnonymous;

public class Receipt {
    private String item;
    private Double price;
    private Double discount;
    private Double tax;

    public Receipt(String item, Double price, Double discount, Double tax) {
        this.item = item;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
    }

    public Receipt(Receipt receipt) {
        item = receipt.item;
        price = receipt.price;
        discount = receipt.discount;
        tax = receipt.tax;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}
