package com.company.baseAnonymous;

@FunctionalInterface
public interface ReceiptPrinter {

    void print(Receipt receipt);

    private Double getDiscount(Receipt receipt) {
        return receipt.getPrice() - receipt.getPrice() * receipt.getDiscount();
    }

    default Double computeTotal(Receipt receipt) {
        Double discountPrice = getDiscount(receipt);
        return discountPrice + discountPrice * receipt.getTax();
    }
}
