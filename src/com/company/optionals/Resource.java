package com.company.optionals;

public class Resource {
   public static int count = 3;

    public Resource() {
        count--;
        System.out.println("Resource consumed " + count + " remaining.");
    }
}
