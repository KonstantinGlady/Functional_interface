package com.company.project4;

abstract class Record {
    String name;
    String phone;
    int index;

    public Record(String name, String phone, int index) {
        this.name = name;
        this.phone = phone;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Record " +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ' ';
    }
}
