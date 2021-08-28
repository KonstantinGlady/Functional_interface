package com.company.project4;

public class GpaRecord extends Record {
    String subject;

    public GpaRecord(String name, String phone, int index, String subject) {
        super(name, phone, index);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " subject: " + subject;
    }
}
