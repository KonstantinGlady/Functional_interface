package com.company.project4;

public class SportRecord extends Record {
    String team;

    public SportRecord(String name, String phone, int index, String team) {
        super(name, phone, index);
        this.team = team;
    }

    @Override
    public String toString() {
        return super.toString() + " favorite team: " + team;
    }
}
