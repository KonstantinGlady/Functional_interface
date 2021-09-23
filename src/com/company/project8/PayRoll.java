package com.company.project8;

import java.util.function.Consumer;

public class PayRoll {

    public static void main(String[] args) {

        Consumer<Employee> applyProfit = x -> x.bonus += MomAndPod.profit * x.multiplier;

        MomAndPod company = new MomAndPod();
        MomAndPod.profit = 120000.0;
        company.forEach(applyProfit.andThen(x -> System.out.println(x)));
    }
}
