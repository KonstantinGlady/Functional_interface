package com.company.baseAnonymous2;

public class Main {
    public static void main(String[] args) {
        StringProcessor toLowerCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toLowerCase();
            }
        };

        StringProcessor toUpperCase = new StringProcessor() {
            @Override
            public String process(String s) {
                return s.toUpperCase();
            }
        };

        String s = "ASDFADFASDFA";
        System.out.println(s);
        String n = toLowerCase.process(s);
        System.out.println(n);
        System.out.println("string is lower case " + StringProcessor.isLowerCase(n));
        System.out.println("string is upper case " + StringProcessor.isUpperCase(n));
    }
}
