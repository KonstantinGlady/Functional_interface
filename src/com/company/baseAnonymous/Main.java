package com.company.baseAnonymous;

public class Main {

    public static void main(String[] args) {
        ReceiptPrinter simpleReceiptPrinter = new ReceiptPrinter() {
            @Override
            public void print(Receipt receipt) {
                System.out.println("item:\t" + receipt.getItem());
                System.out.println("price:\t" + receipt.getPrice());
                System.out.println("discount:\t" + receipt.getDiscount());
                System.out.println("tax:\t" + receipt.getTax());
                System.out.println("total:\t" + computeTotal(receipt));
            }
        };

        ReceiptPrinter exemptReceiptPrinter = new ReceiptPrinter() {
            @Override
            public void print(Receipt receipt) {
                System.out.println("item:\t" + receipt.getItem());
                System.out.println("price:\t" + receipt.getPrice());
                System.out.println("discount:\t" + receipt.getDiscount());
                System.out.println("tax:\t" + receipt.getTax());
                System.out.println("total:\t" + computeTotal(receipt));
            }

            @Override
            public Double computeTotal(Receipt receipt) {
                return receipt.getPrice() - receipt.getPrice() * receipt.getDiscount();
            }
        };

        Receipt receipt = new Receipt("Item", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        exemptReceiptPrinter.print(receipt);
    }
}
