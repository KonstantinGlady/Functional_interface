package com.company.baseAnonymous;

@FunctionalInterface
public interface ReceiptPrinter<X extends Receipt> {

    void print(X receipt);

    private Double getDiscount(X receipt) {
        return receipt.getPrice() - receipt.getPrice() * receipt.getDiscount();
    }

    default Double computeTotal(X receipt) {
        Double discountPrice = getDiscount(receipt);
        return discountPrice + discountPrice * receipt.getTax();
    }
}
